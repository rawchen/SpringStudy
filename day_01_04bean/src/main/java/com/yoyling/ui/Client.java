package com.yoyling.ui;

import com.yoyling.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象

        //默认创建单例对象
        IAccountService as1 = (IAccountService)ac.getBean("accountService");
        IAccountService as2 = (IAccountService)ac.getBean("accountService");

//        System.out.println(as);
        as1.saveAccount();
//        System.out.println(as1);
//        System.out.println(as2);
//        System.out.println(as1 == as2);

        //手动关闭容器
        ac.close();



    }
}
