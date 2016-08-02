package xuan.wen.qin.ssm.service.impl;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import xuan.wen.qin.ssm.common.utils.io.FileTools;
import xuan.wen.qin.ssm.common.utils.io.PropertiesTools;
import xuan.wen.qin.ssm.model.repository.mapper.TestMapper;
import xuan.wen.qin.ssm.service.BasiceService;

/**
 * BasiceServiceImpl<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月25日上午11:24:56
 * @Version 1.0
 * @Address by siShangJie
 */
@Service(value = "basiceService")
@Scope("singleton")
public abstract class BasiceServiceImpl implements BasiceService {
	private static final Logger logger = LoggerFactory
			.getLogger(BasiceServiceImpl.class);

	protected static String rootPath;
	private static Properties props;
	@Autowired(required = true)
	@Qualifier(value = "testMapper")
	protected TestMapper testMapper;
	@Autowired(required = true)
	@Qualifier(value = "propertiesTools")
	protected PropertiesTools propertiesTools;
	@Autowired(required = true)
	@Qualifier(value = "fileTools")
	protected FileTools fileTools;

	@PostConstruct
	@Async
	protected void init() {
		logger.info("basiceService init ....");
		if (null == props) {
			props = propertiesTools.readProperties();
		}
		rootPath = propertiesTools.getPropsByKey("root.path", props);
		logger.debug("rootPath : {}", rootPath);
	}

	@PreDestroy
	@Async
	protected void destory() {
		logger.info("basiceService destory ....");
	}
}
