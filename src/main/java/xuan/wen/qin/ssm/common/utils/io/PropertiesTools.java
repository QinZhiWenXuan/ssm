package xuan.wen.qin.ssm.common.utils.io;

import java.util.Properties;

/**
 * PropertiesTools<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月28日下午12:00:20
 * @Version 1.0
 * @Address by siShangJie
 */
public interface PropertiesTools {
	/***
	 * 读取默认的配置文件
	 * 
	 * @return Properties
	 */
	Properties readProperties();

	/***
	 * 根据配置文件名称读取配置文件
	 * 
	 * @param path
	 *            配置文件名称
	 * @return Properties
	 */
	Properties readProperties(String path);

	/***
	 * 替换占位符
	 * 
	 * @param message
	 *            目标 as 1024{0}
	 * @param param
	 *            替换目标 1GB
	 * @return 替换后的message
	 */
	String formate(String message, Object... param);

	/***
	 * 根据key获取配置文件vaule
	 * 
	 * @param key
	 *            key
	 * @return vaule
	 */
	String getPropsByKey(String key);

	/***
	 * 根据key获取配置文件vaule
	 * 
	 * @param key
	 *            key
	 * @param path
	 *            配置文件名称
	 * @return vaule
	 */
	String getPropsByKey(String key, String path);

	/***
	 * 根据key获取配置文件vaule
	 * 
	 * @param key
	 *            key
	 * @param props
	 *            配置文件
	 * @return vaule
	 */
	String getPropsByKey(String key, Properties props);
}
