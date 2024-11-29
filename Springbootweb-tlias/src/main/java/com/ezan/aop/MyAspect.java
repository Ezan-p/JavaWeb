package com.ezan.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


//测试Demo
@Slf4j
@Component
@Aspect
public class MyAspect {

    //@Pointcut("execution(* com.ezan.service.impl.DeptServiceImpl.*(..))")
    @Pointcut("@annotation(com.ezan.aop.MyLog)")
    public void pt() {
    }

    @Before("pt()")
    public void before() {
        log.info("before method");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around method");

        //1.获取 目标对象的类名
        String className = joinPoint.getTarget().getClass().getName();
        log.info("目标对象类名：{}",className);

        //2.获取 目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        log.info("目标方法的方法名：{}",methodName);

        //3.获取 目标方法运行时传入的参数
        Object[] args = joinPoint.getArgs();
        log.info("目标方法运行传入参数：{}", Arrays.toString(args));

        //4.放行 目标方法执行
        Object result = joinPoint.proceed();

        //5.获取 目标方法的运行时的返回值
        log.info("目标方法运行返回值：{}",result);

        return result;
    }

    @After("pt()")
    public void after() {
        log.info("after method");
    }

    @AfterReturning("pt()")
    public void afterReturning() {
        log.info("afterReturning method");
    }

    @AfterThrowing("pt()")
    public void afterThrowing() {
        log.info("afterThrowing method");
    }

}
