package com.yoyling.service.impl;

import com.yoyling.dao.AccountDao;
import com.yoyling.dao.impl.AccountDaoImpl;
import com.yoyling.domain.Account;
import com.yoyling.service.AccountService;

import java.util.List;

/**
 * 账户的业务实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao dao;

    public void setDao(AccountDao dao) {
        this.dao = dao;
    }

    public List<Account> findAllAccount() {
        return dao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return dao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        dao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        dao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        dao.deleteAccount(accountId);
    }

    public void setAccountDao(AccountDaoImpl accountDao) {
    }
}
