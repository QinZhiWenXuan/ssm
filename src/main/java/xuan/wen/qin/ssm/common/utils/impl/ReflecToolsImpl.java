package xuan.wen.qin.ssm.common.utils.impl;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import xuan.wen.qin.ssm.common.utils.ReflecTools;

/**
 * ReflecToolsImpl
 * 
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年5月27日 下午9:08:01
 * @version 1.0
 */
@Component(value = "reflecTools")
public class ReflecToolsImpl implements ReflecTools {
	private static final Logger logger = LoggerFactory
			.getLogger(ReflecToolsImpl.class);

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
	@SuppressWarnings("unused")
	@Override
	public Field getFileByName(Object instance, String fieldName)
			throws NoSuchFieldException, SecurityException {
		Field field = null;
		if (null != instance && StringUtils.hasText(fieldName))
			try {
				{
					for (Class<?> clazz = instance.getClass(); clazz != Object.class; clazz = clazz
							.getSuperclass()) {
						field = clazz.getDeclaredField(fieldName);
						break;
					}
				}
			} catch (Exception e) {
				logger.error("getFileByName fail : {}", e.getLocalizedMessage());
			}
		return field;
	}

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
	@Override
	public Object getFieldValue(Object instance, String fieldName)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		Object result = null;
		if (null != instance && StringUtils.hasText(fieldName)) {
			Field field = this.getFileByName(instance, fieldName);
			if (null != field) {
				field.setAccessible(true);
				result = field.get(instance);
			}
		}
		return result;
	}

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
	@Override
	public void setFieldValue(Object instance, String fieldName,
			Object fieldValue) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		if (null != instance && StringUtils.hasText(fieldName)
				&& null != fieldValue) {
			Field field = this.getFileByName(instance, fieldName);
			if (null != field) {
				field.setAccessible(true);
				field.set(instance, fieldValue);
			}
		}
	}
}
