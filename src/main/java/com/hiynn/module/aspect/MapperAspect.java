package com.hiynn.module.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * description mapper层方法性能统计
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月08日 9:31
 */
@Aspect
@Component
public class MapperAspect {
	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(MapperAspect.class);

	/**
	 * description  logServiceAccess 
	 * @author LouLvLin
	 * @date  2019/5/8  9:55
	 * @param joinPoint 1
	 * @return void
	 */
	@AfterReturning("execution(* com.hiynn.module.dao.*.get*(..)) && !execution(* com.hiynn.module.dao.*.getMax*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		LOGGER.info("Completed: {}",joinPoint);
	}


	/**
	 * description  pointCutMethod
	 * @author LouLvLin
	 * @date  2019/5/8  9:55
	 * @return void
	 */
	@Pointcut("execution(* com.hiynn.module.dao.*.get*(..)) && !execution(* com.hiynn.module.dao.*.getMax*(..))")
	private void pointCutMethod() {
		// no need do something
	}

	/**
	 * description  doAround
	 * @author LouLvLin
	 * @date  2019/5/8  9:56
	 * @param pjp 1
	 * @return java.lang.Object
	 */
	@Around("pointCutMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long begin = System.nanoTime();
		Object obj = pjp.proceed();
		long end = System.nanoTime();

		LOGGER.info("调用Mapper方法：{}，\n参数：{}，\r\n执行耗时：{}毫秒",
				pjp.getSignature(), pjp.getArgs(), (end - begin) / 1000000);
		return obj;
	}



}


