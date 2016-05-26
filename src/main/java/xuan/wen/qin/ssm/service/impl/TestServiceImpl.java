package xuan.wen.qin.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xuan.wen.qin.ssm.common.exception.SsmException;
import xuan.wen.qin.ssm.model.entity.form.TestSaveForm;
import xuan.wen.qin.ssm.service.TestService;

/**
 * TestServiceImpl<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月25日上午11:31:00
 * @Version 1.0
 * @Address by siShangJie
 */
@Service(value = "testService")
@Transactional(readOnly = true, rollbackFor = SsmException.class)
public class TestServiceImpl extends BasiceServiceImpl implements TestService {
	/***
	 * 保存
	 * 
	 * @param form
	 *            保存参数
	 * @return 保存ID
	 */
	@Transactional(readOnly = false)
	@Override
	public int save(TestSaveForm form) {
		testMapper.save(form);
		return form.getId();
	}

	/***
	 * 获取列表集合
	 * 
	 * @return 列表集合
	 */
	@Override
	public List<Map<String, ?>> getList() {
		// TODO Auto-generated method stub
		return testMapper.query();
	}

}
