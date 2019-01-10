package com.abc;

import com.abc.service.AdviceManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author 刘富鸿
 * @create 2019-01-10 09:23
 */

@Component
public class StartUp implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdviceManager manager = context.getBean(AdviceManager.class);
        //manager.beforeAdvice();
        //manager.afterReturning();
        //manager.afterThrowing();
        //manager.afterAdvice();
        //String result = manager.aroundAdvice("aa", 1, "bb");
        //System.out.println("返回值：" + result);
        String result = manager.manyAdvices("aa", "bb");
        System.out.println("Test方法中调用切点方法的返回值：" + result);
//        manager.accessAdvice(new Date(), "test");
    }
}
