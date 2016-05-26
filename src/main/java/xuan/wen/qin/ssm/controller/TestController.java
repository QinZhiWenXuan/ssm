package xuan.wen.qin.ssm.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xuan.wen.qin.ssm.model.entity.form.TestSaveForm;

/**
 * TestController<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月25日上午10:43:27
 * @Version 1.0
 * @Address by siShangJie
 */
@Controller
@RequestMapping(value = "/test/")
public class TestController extends BasiceController {
	private static final Logger logger = LoggerFactory
			.getLogger(TestController.class);

	/***
	 * 跳转到test页面
	 * 
	 * @return test页面
	 */
	@RequestMapping(value = "to.jspx", method = { RequestMethod.GET })
	public String to() {
		logger.debug("test request....");
		return "test";
	}

	/***
	 * 保存test
	 * 
	 * @param form
	 *            test对象
	 * @param error
	 *            校验提示
	 * @return 保存结果
	 */
	@RequestMapping(value = "save.jspx", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> save(@Valid TestSaveForm form,
			BindingResult error) {
		this.valided(error);
		int result = testService.save(form);
		if (result > 0) {
			jsonMap.put(CODE, SUCCESS_CODE);
			jsonMap.put(MESSAGE, SUCCESS_MESSAGE);
		}
		return jsonMap;
	}

	/***
	 * 获取列表信息
	 * 
	 * @return 列表信息
	 */
	@RequestMapping(value = "get/list.jspx", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> getList() {
		List<Map<String, ?>> info = testService.getList();
		if (null != info && info.size() > 0) {
			jsonMap.put(CODE, SUCCESS_CODE);
			jsonMap.put(MESSAGE, SUCCESS_MESSAGE);
			jsonMap.put(INFO, info);
		}
		return jsonMap;
	}
}
