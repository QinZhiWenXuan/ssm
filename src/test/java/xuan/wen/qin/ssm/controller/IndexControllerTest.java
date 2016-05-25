package xuan.wen.qin.ssm.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	private static final ObjectMapper mapper = new ObjectMapper();
	private final static String JSON = "[Field error in object 'testSaveForm' on field 'remark': rejected value []; codes [NotEmpty.testSaveForm.remark,NotEmpty.remark,NotEmpty.java.lang.String,NotEmpty]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [testSaveForm.remark,remark]; arguments []; default message [remark]]; default message [remark不能为空], Field error in object 'testSaveForm' on field 'remark': rejected value []; codes [Size.testSaveForm.remark,Size.remark,Size.java.lang.String,Size]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [testSaveForm.remark,remark]; arguments []; default message [remark],32,2]; default message [remark长度必须大于1小于33]]";

	@Test
	public void test() {
		String index = "logback";
		logger.trace("======trace");
		logger.debug("debug = {}", index);
		logger.info("======info");
		logger.warn("======warn");
		logger.error("======error");

	}

	public void string2Json() {
	}

}
