package com.abc.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class AccessArgAdviceTest {
    @AfterReturning(
//            pointcut="execution(* com.abc.service.*.access*(..)) && args(time, name)",
            pointcut = "@annotation(com.abc.service.MyTest) && args(time, name)" ,
            returning="returnValue")
    public void access(Date time, Object returnValue, String name) {
        System.out.println("目标方法中的参数String = " + name);
        System.out.println("目标方法中的参数Date = " + time);
        System.out.println("目标方法的返回结果returnValue = " + returnValue);
    }

    @Pointcut("@annotation(com.abc.service.MyTest) && args(time, name)")
    public void pointCut(Date time, String name) {

    }

    @AfterReturning(
            value = "pointCut(time, name)",
            returning="returnValue")
    public void access2(Date time, Object returnValue, String name) {
        System.out.println("目标方法中的参数String = " + name);
        System.out.println("目标方法中的参数Date = " + time);
        System.out.println("目标方法的返回结果returnValue = " + returnValue);
    }
}
