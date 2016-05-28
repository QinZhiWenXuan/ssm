package xuan.wen.qin.ssm.common.utils.io.impl;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import xuan.wen.qin.ssm.common.utils.io.PropertiesTools;

/**
 * PropertiesToolsImpl<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月28日下午12:00:40
 * @Version 1.0
 * @Address by siShangJie
 */
@Component(value = "propertiesTools")
public class PropertiesToolsImpl implements PropertiesTools {
	private static final Logger logger = LoggerFactory
			.getLogger(PropertiesToolsImpl.class);
	private static final String DEFALUT_PATH = "app.properties";

	/***
	 * 读取默认的配置文件
	 * 
	 * @return Properties
	 */
	public Properties readProperties() {
		return this.readProperties(DEFALUT_PATH);
	}

	/***
	 * 根据配置文件名称读取配置文件
	 * 
	 * @param path
	 *            配置文件名称
	 * @return Properties
	 */
	public Properties readProperties(String path) {
		Resource resource = new ClassPathResource(path);
		Properties props = null;
		try {
			props = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			logger.error("读取配置文件失败 ,文件 {},不存在!", path);
		}
		return props;
	}

	/***
	 * 替换占位符
	 * 
	 * @param message
	 *            目标 as 1024{0}
	 * @param param
	 *            替换目标 1GB
	 * @return 替换后的message
	 */
	public String formate(String message, Object... param) {
		return MessageFormat.format(message, param);
	}

	/***
	 * 根据key获取配置文件vaule
	 * 
	 * @param key
	 *            key
	 * @return vaule
	 */
	public String getPropsByKey(String key) {
		Properties props = this.readProperties();
		return this.getPropsByKey(key, props);
	}

	/***
	 * 根据key获取配置文件vaule
	 * 
	 * @param key
	 *            key
	 * @param path
	 *            配置文件名称
	 * @return vaule
	 */
	public String getPropsByKey(String key, String path) {
		Properties props = this.readProperties(path);
		return this.getPropsByKey(key, props);
	}

	/***
	 * 根据key获取配置文件vaule
	 * 
	 * @param key
	 *            key
	 * @param props
	 *            配置文件
	 * @return vaule
	 */
	public String getPropsByKey(String key, Properties props) {
		String result = "";
		if (null != props) {
			result = props.getProperty(key);
		}
		return result;
	}
}
