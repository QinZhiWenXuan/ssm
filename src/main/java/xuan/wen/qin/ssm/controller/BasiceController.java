package xuan.wen.qin.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import xuan.wen.qin.ssm.common.exception.SsmVaildException;
import xuan.wen.qin.ssm.service.TestService;

/**
 * BasiceController<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月25日上午10:42:43
 * @Version 1.0
 * @Address by siShangJie
 */
@Controller
public class BasiceController {
	protected static final String CODE = "code";
	protected static final String MESSAGE = "message";
	protected static final String FAIL_CODE = "400";
	protected static final String SUCCESS_CODE = "200";
	protected static final String FAIL_MESSAGE = "execute fail";
	protected static final String SUCCESS_MESSAGE = "execute success";
	protected Map<String, Object> jsonMap;
	@Autowired(required = true)
	@Qualifier(value = "testService")
	protected TestService testService;
	private static final Logger logger = LoggerFactory
			.getLogger(BasiceController.class);

	/***
	 * @remark 可以准备一些重复使用的数据 <br>
	 *         初始化
	 */
	@ModelAttribute
	public void init() {
		logger.debug("controller init...");
		jsonMap = new HashMap<String, Object>(3);
		jsonMap.put(CODE, FAIL_CODE);
		jsonMap.put(MESSAGE, FAIL_MESSAGE);
	}

	/***
	 * 校验参数是否符合规范
	 * 
	 * @param error
	 *            校验提示
	 */
	protected void valided(BindingResult error) {
		if (error.hasErrors()) {
			String message = error.getFieldError().getDefaultMessage();
			logger.error("校验失败 : {}", message);
			throw new SsmVaildException(message);
		}

	}
}
