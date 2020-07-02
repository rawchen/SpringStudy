package com.yoyling.service.impl;

import com.yoyling.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl对象创建了");
    }

    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了");
    }
}
