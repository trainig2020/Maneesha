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
public class OrganizationAspect {
	

	Service service = SplunkConfig.getSplunkService();
	Receiver rec = service.getReceiver();
	
	@Pointcut("execution(* com.Organization_Service.service..*(..))")
	public void organizationService() {
		
	}
	

	@Pointcut("execution(* com.Organization_Service.controller..*(..))")
	public void organizationController() {
		
	}
	

	
	@Before("organizationService() && organizationController()")
	@Order(1)
	public void beforeAdvice(JoinPoint joinPoint) {
		rec.log("main","Before Advice Method in Organization Application  "+joinPoint.getSignature().getName()
				+ "  Method");
		 rec.log("main","Signature declaring type : " + joinPoint.getSignature().getDeclaringTypeName());
		 rec.log("main","Signature name : " + joinPoint.getSignature().getName());
		 rec.log("main","Arguments : " + Arrays.toString(joinPoint.getArgs()));
		 rec.log("main","Target class : " + joinPoint.getTarget().getClass().getName());

	
	

	}

	@After("organizationService() && organizationController()")
	@Order(2)
	public void afterAdviceMethod(JoinPoint joinPoint) {
		rec.log("main","After Advice Method in Organization Application  "+joinPoint.getSignature().getName()
				+ "  Method");
		rec.log("main","Exiting from Method :" + joinPoint.getSignature().getName());
		rec.log("main","Signature declaring type :" + joinPoint.getSignature().getDeclaringTypeName());
	
	
	
	}



    @Around("organizationService() && organizationController()")
    @Order(3)
    public Object logAroundOrganization(ProceedingJoinPoint joinPoint) throws Throwable
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
