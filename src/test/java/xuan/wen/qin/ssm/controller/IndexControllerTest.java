package xuan.wen.qin.ssm.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IndexControllerTest<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月18日下午1:55:36
 * @Version 1.0
 * @Address by siShangJie
 */
public class IndexControllerTest {
	private static final Logger logger = LoggerFactory
			.getLogger(IndexControllerTest.class);

	@Test
	public void test() {
		String index = "logback";
		logger.trace("======trace");
		logger.debug("debug = {}", index);
		logger.info("======info");
		logger.warn("======warn");
		logger.error("======error");

	}
}
