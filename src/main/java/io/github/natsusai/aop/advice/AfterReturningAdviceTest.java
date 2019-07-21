package io.github.natsusai.aop.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturningAdviceTest {
    //匹配com.abc.service下的类中以afterReturning开始的方法
    @AfterReturning(returning="returnValue", pointcut="execution(* io.github.natsusai.aop.service.*.afterReturning(..))")
    public void log(Object returnValue){
        System.out.println("目标方法返回值：" + returnValue);
        System.out.println("模拟日志记录功能...");
    }
}
