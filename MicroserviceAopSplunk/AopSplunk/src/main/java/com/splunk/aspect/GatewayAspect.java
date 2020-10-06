package com.splunk.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
public class GatewayAspect {

	Service service = SplunkConfig.getSplunkService();
	Receiver rec = service.getReceiver();

	@Pointcut("execution(* com.APIGateway.controller..*(..))")
	public void gatewayController() {

	}

	@Before("gatewayController()")
	@Order(1)
	public void beforeAdvice(JoinPoint joinPoint) {
		rec.log("main", "Before Advice Method in Api Gateway Application FallBack controller "
				+ joinPoint.getSignature().getName() + "  Method");
		rec.log("main", "Signature declaring type : " + joinPoint.getSignature().getDeclaringTypeName());
		rec.log("main", "Signature name : " + joinPoint.getSignature().getName());
		rec.log("main", "Arguments : " + Arrays.toString(joinPoint.getArgs()));
		rec.log("main", "Target class : " + joinPoint.getTarget().getClass().getName());

	}

	@After("gatewayController()")
	@Order(2)
	public void afterAdviceMethod(JoinPoint joinPoint) {
		rec.log("main", "After Advice Method in Api Gateway Application FallBack controller  "
				+ joinPoint.getSignature().getName() + "  Method");
		rec.log("main", "Exiting from Method :" + joinPoint.getSignature().getName());
		rec.log("main", "Signature declaring type :" + joinPoint.getSignature().getDeclaringTypeName());

	}

}
