package com.splunk.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.splunk.Receiver;
import com.splunk.Service;
import com.splunk.config.SplunkConfig;



@Aspect
@Component
public class DepartmentAspect {
	
	
	Service service = SplunkConfig.getSplunkService();
	Receiver rec = service.getReceiver();
	
	@Pointcut("execution(* com.rest.dao..*(..))")
	public void departmentRepository() {
		
	}
	

	@Pointcut("execution(* com.rest.service..*(..))")
	public void departmentService() {
		
	}
	

	@Pointcut("execution(* com.rest.controller..*(..))")
	public void departmentController() {
		
	}
	
	
	
	@Before("departmentService() && departmentController()")
	@Order(1)
	public void beforeAdvice(JoinPoint joinPoint) {
		rec.log("main","Before Advice Method in Department Application  "+joinPoint.getSignature().getName()
				+ "  Method");
		 rec.log("main","Signature declaring type : " + joinPoint.getSignature().getDeclaringTypeName());
		 rec.log("main","Signature name : " + joinPoint.getSignature().getName());
		 rec.log("main","Arguments : " + Arrays.toString(joinPoint.getArgs()));
		 rec.log("main","Target class : " + joinPoint.getTarget().getClass().getName());

	

	}
    
	
	@After("departmentService() && departmentController()")
	@Order(2)
	public void afterAdviceMethod(JoinPoint joinPoint) {
		rec.log("main","After Advice Method in Department Application  "+joinPoint.getSignature().getName()
				+ "  Method");
		rec.log("main","Exiting from Method :" + joinPoint.getSignature().getName());
		rec.log("main","Signature declaring type :" + joinPoint.getSignature().getDeclaringTypeName());
	
	
	}
	
	

    @Around("departmentService() && departmentController()")
    @Order(3)
    public Object logAroundDepartment(ProceedingJoinPoint joinPoint) throws Throwable
    {
    rec.log("main","The method " + joinPoint.getSignature().getName() + "() begins with " + Arrays.toString(joinPoint.getArgs()));
    try
    {
        Object result = joinPoint.proceed();
        rec.log("main","The method " + joinPoint.getSignature().getName() + "() ends with " + result);
        return result;
    }
    catch (IllegalArgumentException e)
    {
        rec.log("main","Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in " + joinPoint.getSignature().getName() + "()");
        throw e;
    }
    }



	

	

}
