package xuan.wen.qin.ssm.model.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xuan.wen.qin.ssm.common.web.servlet.PageModel;
import xuan.wen.qin.ssm.model.entity.form.TestEditForm;
import xuan.wen.qin.ssm.model.entity.form.TestSaveForm;
import xuan.wen.qin.ssm.model.entity.vo.TestVO;

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

	/***
	 * 获取列表集合
	 * 
	 * @return 列表集合
	 */
	List<TestVO> queryForVO();

	/***
	 * 更新
	 * 
	 * @param form
	 *            更新参数
	 * @return 受影响行数
	 */
	int update(@Param(value = "form") TestEditForm form);

	/***
	 * 分页查询
	 * 
	 * @param pageModel
	 *            分页实体
	 * @return 结果集
	 */
	List<Map<String, ?>> queryByPage(
			@Param(value = "pageModel") PageModel<Map<String, ?>> pageModel);

}
