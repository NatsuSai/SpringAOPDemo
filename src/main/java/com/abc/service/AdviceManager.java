package com.abc.service;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AdviceManager {
    //将被BeforeAdviceTest的permissionCheck方法匹配
    @GetMapping("beforeAdvice")
    public void beforeAdvice() {
        System.out.println("方法: beforeAdviceTest");
    }
    
    //将被AfterReturningAdviceTest的log方法匹配
    @GetMapping("afterReturning")
    public String afterReturning() {
        System.out.println("方法：afterReturning");
        return "afterReturning方法";
    }
    
    //将被AfterThrowingAdviceTest的handleException方法匹配
    @SuppressWarnings({ "null", "unused" })
    @GetMapping("afterThrowing")
    public void afterThrowing() {
        System.out.println("方法： afterThrowing");
        try {
            int a = 10 / 0;
        } catch (ArithmeticException ae) {
            System.out.println("算术异常已被处理");
        }
        String s = null;
        System.out.println(s.substring(0,3));
    }
    
    //将被AfterAdvice的releaseResource方法匹配
    @GetMapping("afterAdvice")
    public void afterAdvice() {
        System.out.println("方法： afterAdvice");
    }
    
    //将被AroundAdvice的process方法匹配
    @GetMapping("aroundAdvice")
    public String aroundAdvice(String param1, Integer param2, Object param3) {
        System.out.println("方法： aroundAdvice");
        return param1;
    }
    
    //将被AdviceTest的各种方法匹配
    @GetMapping("/manyAdvices")
    public String manyAdvices(String param1, String param2) {
        System.out.println("方法：manyAdvices");
        return param1 + " 、 " + param2;
    }
    
    //将被AccessArgAdviceTest的access方法匹配
    @MyTest
    @GetMapping("/accessAdvice")
    public String accessAdvice(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date d, String n) {
        System.out.println("方法：accessAdvice");
        return "aa";
    }
}