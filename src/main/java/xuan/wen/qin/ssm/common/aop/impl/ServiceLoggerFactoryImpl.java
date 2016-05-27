package xuan.wen.qin.ssm.common.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import xuan.wen.qin.ssm.common.aop.ServiceLoggerFactory;

/**
 * ServiceLoggerImpl<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月27日上午11:04:32
 * @Version 1.0
 * @Address by siShangJie
 */
@Aspect
@Component(value = "serviceLoggerFactory")
public class ServiceLoggerFactoryImpl implements ServiceLoggerFactory {
	private static final Logger logger = LoggerFactory
			.getLogger(ServiceLoggerFactoryImpl.class);
	/** 开始时间毫秒数 */
	private long beginMillis;
	/** 结束时间毫秒数 */
	private long endMillis;

	/***
	 * 调用开始之前
	 * 
	 * @param joinPoint
	 */
	@Override
	@Before("execution(* xuan.wen.qin.ssm.service.*.*.*(..))")
	public void invokeBefore(JoinPoint joinPoint) {
		String target = this.getTarget(joinPoint);
		logger.info("开始调用【" + target + "】方法！");
		beginMillis = System.currentTimeMillis();
		logger.info("开始调用的毫秒数：" + beginMillis);

	}

	/***
	 * 调用结束之后
	 * 
	 * @param joinPoint
	 * @param instance
	 */
	@Override
	@AfterReturning(pointcut = "execution(* xuan.wen.qin.ssm.service.*.*.*(..))", returning = "instance")
	public void invokeAfter(JoinPoint joinPoint, Object instance) {
		String target = this.getTarget(joinPoint);
		logger.info("结束调用【" + target + "】方法，返回值：" + instance);
		endMillis = System.currentTimeMillis();
		long diff = endMillis - beginMillis;
		logger.info("调用该【" + target + "】方法，一共花费了【" + diff + "】毫秒！");

	}

	/***
	 * 异常
	 * 
	 * @param joinPoint
	 * @param ex
	 */
	@Override
	@AfterThrowing(pointcut = "execution(* xuan.wen.qin.ssm.service.*.*.*(..))", throwing = "ex")
	public void invokeError(JoinPoint joinPoint, Throwable ex) {
		String target = this.getTarget(joinPoint);
		logger.info("调用【" + target + "】方法，出现了异常！");
		logger.error(ex.getMessage(), ex);
	}

	/***
	 * 获取方法名
	 * 
	 * @param joinPoint
	 * @return 完整类名.方法名
	 */
	private String getTarget(JoinPoint joinPoint) {
		Class<?> clazz = this.getClass(joinPoint);
		String method = joinPoint.getSignature().getName();
		StringBuilder result = new StringBuilder(clazz.toString());
		result.append(".").append(method).append("(...)");
		return result.toString();
	}

	/***
	 * 获取目标类
	 * 
	 * @param joinPoint
	 * @return 目标类
	 */
	private Class<?> getClass(JoinPoint joinPoint) {
		return joinPoint.getTarget().getClass();
	}
}
