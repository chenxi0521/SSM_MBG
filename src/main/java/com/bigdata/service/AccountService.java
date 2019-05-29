package com.bigdata.service;

import com.bigdata.domain.Account;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AccountService {

    void saveAccount(Account account);
    
    List<Account> findAll();

    List<Account> findSingle(String name);

    Integer  delete(String name);

    void update(Account account);

    List<Account> findByExample(Account account);

    PageInfo findByPages(Integer pageNum,Integer pageSize);

    void delete_id(Integer id);

    Account findById(Integer id);

    void saveOrUpdate(Account account);
}
