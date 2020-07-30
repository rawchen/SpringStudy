package com.yoyling.test;

import com.yoyling.domain.Account;
import com.yoyling.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 *
 * 1.应用程序的入口
 *      main方法
 * 2.junit单元测试中没有main方法也能执行
 *      junit集成了一个main方法
 *      该方法就会判断当前测试类中那些方法有@Testz注解
 *      junit就会让有Test注解的方法执行
 * 3.junit不会管我们是否采用spring框架
 *      在执行测试方法时，junit根本不知道我们是不是使用了spring框架
 *      所以也就不会为我们读取配置文件/配置类创建sping核心容器
 * 4.由以上三点可知
 *      当测试方法执行时，没有ioc容器，就算写了Autowired注解，也无法实现注入
 *  -----------------------------------------
 *  Spring整合了junit的配置
 *      1.d导入spring整合junit的jar（坐标）
 *      2.使用Junit提供的一个注解把原来的main方法替换了，替换为spring提供的
 *          @Runwith
 *      3.
 *
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {

//    private ApplicationContext ac;
    @Autowired
    private AccountService as;

//    @Before
//    public void init() {
//        //1.获取容器
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        //2.得到业务层对象
//        AccountService as = ac.getBean("accountService",AccountService.class);
//    }

    @Test
    public void testFinAll() {
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        as.deleteAccount(4);
    }
}
