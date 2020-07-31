package com.yoyling.service.impl;

import com.yoyling.dao.AccountDao;
import com.yoyling.factory.BeanFactory;
import com.yoyling.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

//    private AccountDao accountDao = new AccountDaoImpl();

    private AccountDao accountDao = (AccountDao)BeanFactory.getBean("accountDao");

//    private int i = 1;

    public void  saveAccount(){
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
