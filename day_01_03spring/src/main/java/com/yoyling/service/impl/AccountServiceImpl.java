package com.yoyling.service.impl;

import com.yoyling.dao.IAccountDao;
import com.yoyling.dao.impl.AccountDaoImpl;
import com.yoyling.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl对象创建了");
    }

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
