package com.yoyling.ui;

import com.yoyling.dao.IAccountDao;
import com.yoyling.service.IAccountService;
import com.yoyling.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * 获取spring的IOC核心容器，并根据id获取对象
     * ApplicationContext的三个常用实现类
     *      ClassPathXmlApplicationContext  可以加载类路径下的配置文件
     *      FileSystemXmlApplicationContext  可以加载磁盘任意路径下的配置文件(必须有访问权限)
     *      AnnotationConfigApplicationContext  它是用于读取注解创建容器的
     *
     * 核心容器的两个接口引发的出的问题
     * ApplicationContext       单例对象适用      采用此接口
     *      它在构建核心容器时，创建对象采取的策略是立即加载的方式，一读取文件马上就创建配置文件中配置的对象。
     * BeanFactory              多例对象适用
     *      它在构建核心容器时，创建对象采取的策略是延迟加载的方式，什么时候根据id获取对象了，什么时候才真正创建了对象。
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
//        IAccountService as = (IAccountService)ac.getBean("accountService");
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);

//        System.out.println(as);
//        System.out.println(adao);


        //--------------------BeanFactory-----------------------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        IAccountService as = (IAccountService)beanFactory.getBean("accountService");
        System.out.println(as);

    }
}
