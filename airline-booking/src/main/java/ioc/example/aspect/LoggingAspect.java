package ioc.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.DateFormat;

@Component
@Aspect
public class LoggingAspect {
    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @AfterThrowing("execution(* ioc.example.services.FlightServiceImpl.addFlight(..))")
    public void logAfterThrowingAdvice(JoinPoint joinPoint) {
        logger.info("In After throwing Advice, Joinpoint signature :{}", joinPoint.getSignature());
    }
    @AfterThrowing(pointcut = "execution(* ioc.example.services.FlightServiceImpl.addFlight(..))", throwing = "exception")
    public void logAfterThrowingAdviceDetails(JoinPoint joinPoint, Exception exception) {
        logger.info("In After throwing Advice, Joinpoint signature :{}", joinPoint.getSignature());
        logger.error(exception.getMessage(),exception);
    }
    @After("execution(* ioc.example.services.FlightServiceImpl.addFlight(..))")
    public void logAfterAdvice(JoinPoint joinPoint) {
        logger.info("In After Advice, Joinpoint signature :{}", joinPoint.getSignature());
        long time = System.currentTimeMillis();
        String date = DateFormat.getDateTimeInstance().format(time);
        logger.info("Report generated at time {}", date);
    }
    @Before("execution(* ioc.example.services.FlightServiceImpl.addFlight(..))")
    public void logBeforeAdvice(JoinPoint joinPoint) {
        // Log Joinpoint signature details
        logger.info("In Before Advice, Joinpoint signature :{}", joinPoint.getSignature());
        long time = System.currentTimeMillis();
        String date = DateFormat.getDateTimeInstance().format(time);
        logger.info("Report generated at time:{}", date);
    }

    @AfterReturning(pointcut = "execution(* ioc.example.services.FlightServiceImpl.addFlight(..))")
    public void logAfterReturningAdvice(JoinPoint joinPoint) {
        logger.info("In AfterReturning Advice, Joinpoint signature :{}", joinPoint.getSignature());
    }
    @Around("execution(* ioc.example.services.FlightServiceImpl.addFlight(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before proceeding part of the Around advice.");
        Object cust =  joinPoint.proceed();
        System.out.println("After proceeding part of the Around advice.");
        return cust;
    }
}
