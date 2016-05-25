package xuan.wen.qin.ssm.model.repository.mapper;

import org.springframework.stereotype.Repository;

import xuan.wen.qin.ssm.model.entity.form.TestSaveForm;

/**
 * TestMapper<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月25日上午11:34:44
 * @Version 1.0
 * @Address by siShangJie
 */
@Repository(value = "testMapper")
public interface TestMapper extends BasiceMapper {

	/***
	 * 保存
	 * 
	 * @param form
	 *            保存参数
	 * @return 受影响行数,不是ID
	 */
	int save(TestSaveForm form);

}
