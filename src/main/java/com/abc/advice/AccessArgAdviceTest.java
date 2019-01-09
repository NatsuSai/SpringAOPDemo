package com.abc.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

@Aspect
public class AccessArgAdviceTest {
    @AfterReturning(
            pointcut="execution(* com.abc.service.*.access*(..)) && args(time, name)",
            returning="returnValue")
    public void access(Date time, Object returnValue, String name) {
        System.out.println("目标方法中的参数String = " + name);
        System.out.println("目标方法中的参数Date = " + time);
        System.out.println("目标方法的返回结果returnValue = " + returnValue);
    }
}
