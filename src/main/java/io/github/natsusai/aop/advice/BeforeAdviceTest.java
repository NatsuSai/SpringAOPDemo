package io.github.natsusai.aop.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAdviceTest {
    //匹配com.abc.service下的类中以before开始的方法
    @Before("execution(* io.github.natsusai.aop.service.*.before*(..))")
    public void PermissionCheck() {
        System.out.println("模拟权限检查");
    }
}