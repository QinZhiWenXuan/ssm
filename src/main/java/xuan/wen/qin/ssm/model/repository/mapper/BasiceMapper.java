package xuan.wen.qin.ssm.model.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * BasiceMapper<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月25日上午11:34:17
 * @Version 1.0
 * @Address by siShangJie
 */
public interface BasiceMapper {
	/***
	 * 获取列表集合
	 * 
	 * @return 列表集合
	 */
	List<Map<String, ?>> query();

	/***
	 * 根据ID查询实体
	 * 
	 * @param id
	 *            id
	 * @return 实体
	 */
	Map<String, ?> queryById(@Param(value = "id") int id);

	/***
	 * 物理删除
	 * 
	 * @param id
	 *            id
	 * @return 受影响行数
	 */
	int removeById(@Param(value = "id") int id);

	/***
	 * 逻辑删除
	 * 
	 * @param id
	 *            id
	 * @return 受影响行数
	 */
	int deleteById(@Param(value = "id") int id);
}
