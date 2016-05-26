package xuan.wen.qin.ssm.service;

import java.util.List;
import java.util.Map;

import xuan.wen.qin.ssm.model.entity.form.TestSaveForm;

/**
 * TestService<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月25日上午11:30:34
 * @Version 1.0
 * @Address by siShangJie
 */
public interface TestService extends BasiceService {

	/***
	 * 保存
	 * 
	 * @param form
	 *            保存参数
	 * @return 保存ID
	 */
	int save(TestSaveForm form);

	/***
	 * 获取列表集合
	 * 
	 * @return 列表集合
	 */
	List<Map<String, ?>> getList();

}
