//Ques3. After, AfterReturning, AfterThrowing, Around advices
package com.au.aop.aspect;

import org.aspectj.lang.annotation.*;

//multiple advices inside aspect
@Aspect
public class LoggingAspect {

//	@Before("execution(public * get*())")
//	public void LoggingAdvice() {
//		System.out.println("Logging Advice");
//	}

//	@Before("allGetters()")
//	public void SecondAdvice() {
//		System.out.println("Second Advice");
//	}

	@After("allGetters()")
	public void afterAdvice(){
		System.out.println("After Advice from Getters");
	}

	@AfterReturning("allSetters()")
	public void afterReturning(){
		System.out.println("After Returning from Setters");
	}

	@AfterThrowing("execution(public * getName())")
	public void afterThrowing(){
		System.out.println("After throwing from Triangle getName");
	}

	@Around("execution(public * getName())")
	public void aroundAdvices(){
		System.out.println("Around Advice ");
	}

	//Define pointcut expression
	@Pointcut("execution(public * get*(..))")
	public void allGetters() { 
		/* this is a dummy method for holding pointcut expressions, so they can be referenced later in annotations @Before etc */
	}

	//Define pointcut expression
	@Pointcut("execution(public * set*(..))")
	public void allSetters() {
	}

}

