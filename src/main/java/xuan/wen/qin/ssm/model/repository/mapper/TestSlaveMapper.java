package xuan.wen.qin.ssm.model.repository.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * TestSlaveMapper<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月27日下午2:14:45
 * @Version 1.0
 * @Address by siShangJie
 */
@Repository(value = "testSlaveMapper")
public interface TestSlaveMapper {

	/***
	 * 根据masterId查询slave列表
	 * 
	 * @param id
	 *            masterId
	 * @return slave列表
	 */
	List<Map<String, ?>> loadByMasterId(int id);

}
