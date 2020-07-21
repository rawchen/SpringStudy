package com.yoyling.service.impl;

import com.yoyling.dao.IAccountDao;
import com.yoyling.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 * 曾经XML配置：
 * <bean id="accountService" class="com.yoyling.service.impl.AccountServiceImpl"
 *     scope="" init-method="" destroy-method="" >
 *     <property name="" value="" | ref=""></property>
 * </bean>
 *
 * 用于创建对象的注解
 *     它们的作用就和在XML配置文件中编写一个<bean>标签实现的功能是一样的
 *     @Component
 *         作用：用于把当前类存入spring容器中
 *         属性：value 用于指定bean的id，不写时，默认值为当前类名，且首字母改小写。
 *     @Controller
 *         一般用在表现层
 *     @Service
 *         一般用在业务层
 *     @Repository
 *         一般用于持久层
 *     以上三个注解他们的作用和属性与Component是一模一样。
 *     他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰。
 *
 * 用于注入数据的注解
 *     它们的作用就和在XML配置文件中的<bean>标签中写一个<property>标签的作用是一样的
 *     @Autowired:
 *         作用：自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配就可以注入成功
 *              如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错。
 *              如果ioc容器中有多个类型匹配时：
 *         出现位置：
 *              可以是变量上，也可以是方法上
 *         细节：
 *              在使用注解注入时，set方法就不是必须的。
 *     @Qualifier:
 *         作用：在按照类中注入的基础之上再按照名称注入。它在给类成员注入时不能单独使用。但是在给方法参数注入时可以
 *         属性：
 *             value：用于指定注入bean的id。
 *     @Resource:
 *         作用：直接按照bean的id注入，它可以独立使用
 *         属性：
 *             name：用于指定bean的id
 *     以上三个注解都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
 *     另外集合类型的注入只能通过XML来实现。
 *
 *     @Value：
 *          作用：用于注入基本类型和String类型的数据
 *          属性：
 *              value：用于指定数据的值，它可以用spring中SpEL(Spring的el表达式)
 *                         SpEL的写法：${表达式}
 * 用于改变作用范围的
 *     它们的作用就和在<bean>标签中使用scope属性实现的功能是一样的
 *     @Scope
 *         作用：用于指定bean的作用范围
 *         属性：
 *             value：指定范围的取值。常用取值singleton  prototype
 * 和生命周期相关
 *     它们的作用就和在<bean>标签中使用init-method、destroy-method是一样的
 *     @PreDestroy
 *         作用：用于指定销毁方法
 *     @PostCoustruct
 *         用于指定初始化方法
 */
@Service("accountService")
//@Scope("prototype")//多例
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name = "accountDao1")
    private IAccountDao accountDao = null;

//    public AccountServiceImpl() {
//        System.out.println("AccountServiceImpl对象创建了");
//    }

    @PostConstruct
    public void  init(){
        System.out.println("初始化方法执行了");
    }

    @PreDestroy
    public void  destroy(){
        System.out.println("销毁方法执行了");

    }
    public void  saveAccount(){
        accountDao.saveAccount();
    }

    String a = "";
}
