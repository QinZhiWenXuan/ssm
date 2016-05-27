package xuan.wen.qin.ssm.common.utils;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xuan.wen.qin.ssm.common.utils.impl.ReflecToolsImpl;
import xuan.wen.qin.ssm.model.entity.vo.TestVO;

/**
 * JunitReflecTools
 * 
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年5月27日 下午9:32:34
 * @version 1.0
 */
public class JunitReflecTools {
	private static final Logger logger = LoggerFactory
			.getLogger(JunitReflecTools.class);
	private ReflecTools tools;
	private TestVO instance;

	@Before
	public void init() {
		logger.debug("init...");
		tools = new ReflecToolsImpl();
		instance = new TestVO();
	}

	@Test
	public void test() {
		instance.setId(1);
		try {
			int id = (int) tools.getFieldValue(instance, "id");
			logger.debug("getFieldValue id : {}", id);
			tools.setFieldValue(instance, "id", 2);
			tools.setFieldValue(instance, "remark", "这是备注");
			tools.setFieldValue(instance, "addTime", new Date());
			logger.info("instance : {}", instance.toString());
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
