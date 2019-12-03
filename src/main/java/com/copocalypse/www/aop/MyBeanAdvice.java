package com.copocalypse.www.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyBeanAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("myTestMoethod() Before");
		Object obj = invocation.proceed();
		System.out.println("myTestMethod() After");

		return obj;
	}
}
