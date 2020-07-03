package com.yoyling.factory;

import com.yoyling.service.IAccountService;
import com.yoyling.service.impl.AccountServiceImpl;

public class InstanceFactory {
    /**
     * 模拟一个工厂类（该类可能是存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数）
     */
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
