package com.yoyling.service.impl;

import com.yoyling.dao.IAccountDao;
import com.yoyling.service.IAccountService;
import org.springframework.stereotype.Component;

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
 * 用于改变作用范围的
 *     它们的作用就和在<bean>标签中使用scope属性实现的功能是一样的
 * 和生命周期相关
 *     它们的作用就和在<bean>标签中使用init-method、destroy-method是一样的
 */
@Component("accountService")
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl对象创建了");
    }

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
