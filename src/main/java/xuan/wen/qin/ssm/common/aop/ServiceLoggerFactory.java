package xuan.wen.qin.ssm.common.aop;

import org.aspectj.lang.JoinPoint;

/**
 * ServiceLoggerFactory<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月27日上午11:03:18
 * @Version 1.0
 * @Address by siShangJie
 */
public interface ServiceLoggerFactory {

	/***
	 * 调用开始之前
	 * 
	 * @param joinPoint
	 */
	void invokeBefore(JoinPoint joinPoint);

	/***
	 * 调用结束之后
	 * 
	 * @param joinPoint
	 * @param instance
	 */
	void invokeAfter(JoinPoint joinPoint, Object instance);

	/***
	 * 异常
	 * 
	 * @param joinPoint
	 * @param ex
	 */
	void invokeError(JoinPoint joinPoint, Throwable ex);
}
