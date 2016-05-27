package xuan.wen.qin.ssm.common.utils;

import java.lang.reflect.Field;

/**
 * ReflecTools
 * 
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年5月27日 下午9:07:27
 * @version 1.0
 */
public interface ReflecTools {

	/***
	 * 根据字段名获取字段
	 * 
	 * @param instance
	 *            目标对象
	 * @param fieldName
	 *            字段名
	 * @return 字段
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	Field getFileByName(Object instance, String fieldName)
			throws NoSuchFieldException, SecurityException;

	/***
	 * 通过反射获取成员变量的值
	 * 
	 * @param instance
	 *            目标
	 * @param fieldName
	 *            目标成员变量名称
	 * @return 成员变量的值
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	Object getFieldValue(Object instance, String fieldName)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException;

	/***
	 * 通过反射设置成员变量的值
	 * 
	 * @param instance
	 *            目标
	 * @param fieldName
	 *            目标成员变量名称
	 * @param fieldValue
	 *            成员变量的值
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	void setFieldValue(Object instance, String fieldName, Object fieldValue)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException;
}
