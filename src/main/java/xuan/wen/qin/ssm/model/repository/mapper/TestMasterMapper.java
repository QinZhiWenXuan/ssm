package xuan.wen.qin.ssm.model.repository.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * TestMasterMapper<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月27日下午2:10:13
 * @Version 1.0
 * @Address by siShangJie
 */
@Repository(value = "testMasterMapper")
public interface TestMasterMapper {

	/***
	 * 加载数据
	 * 
	 * @remark 包括分表的数据
	 * @return 数据
	 */
	List<Map<String, ?>> load();

	/***
	 * 查询所有的数据
	 * 
	 * @remark 包括分表的数据
	 * @return 数据
	 */
	List<Map<String, ?>> queryAll();
}
