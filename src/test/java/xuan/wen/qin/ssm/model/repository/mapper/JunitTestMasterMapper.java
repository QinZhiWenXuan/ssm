package xuan.wen.qin.ssm.model.repository.mapper;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * JunitTestMasterMapper<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月27日下午2:36:46
 * @Version 1.0
 * @Address by siShangJie
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:*-test.xml" })
public class JunitTestMasterMapper {
	private static final Logger logger = LoggerFactory
			.getLogger(JunitTestMasterMapper.class);
	@Autowired(required = true)
	@Qualifier(value = "testMasterMapper")
	private TestMasterMapper testMasterMapper;

	@Test
	public void load() {
		List<Map<String, ?>> loadColl = testMasterMapper.load();
		for (Map<String, ?> load : loadColl) {
			logger.info("load : {}", load.toString());
		}
	}

	@Test
	public void queryAll() {
		List<Map<String, ?>> loadColl = testMasterMapper.queryAll();
		for (Map<String, ?> load : loadColl) {
			logger.info("queryAll : {}", load.toString());
		}
	}
}
