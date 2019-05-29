package com.bigdata.service.impl;


import com.bigdata.domain.Account;
import com.bigdata.domain.AccountExample;
import com.bigdata.mapper.AccountMapper;
import com.bigdata.service.AccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;

    @Override
    public void saveAccount(Account account) {
        mapper.insert(account);
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = mapper.selectByExample(null);
        return accounts;
    }

    @Override
    public List<Account> findSingle(String name){

        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria().andNameEqualTo(name);

        List<Account> accounts = mapper.selectByExample(example);
        return accounts;
    }

    @Override
    public Integer delete(String name) {

        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria().andNameEqualTo(name);

        Integer delete = mapper.deleteByExample(example);
        return delete;
    }

    @Override
    public void update(Account account) {

        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria().andIdEqualTo(account.getId());

        mapper.updateByExample(account,example);
    }


    @Override
    public List<Account> findByExample(Account account){
        //example用来构建查询条件
        AccountExample example = new AccountExample();
        //criteria用来存放条件
        AccountExample.Criteria criteria = example.createCriteria();
        //根据传入的参数构建查询条件
        if (!StringUtils.isEmpty(account.getName())){
            //where name = account.getName()
            criteria.andNameEqualTo(account.getName());
        }
        if (!StringUtils.isEmpty(account.getMoney())){
            criteria.andMoneyGreaterThanOrEqualTo(account.getMoney());
        }
        List<Account> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public PageInfo findByPages(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Account> accounts = mapper.selectByExample(null);
        PageInfo page = new PageInfo(accounts);
        return page;
    }

    @Override
    public void delete_id(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Account findById(Integer id) {

        Account account = mapper.selectByPrimaryKey(id);
        return account;
    }

    @Override
    public void saveOrUpdate(Account account) {
        if(StringUtils.isEmpty(account.getId())){
            mapper.insert(account);
        }else {
            AccountExample example = new AccountExample();
            AccountExample.Criteria criteria = example.createCriteria().andIdEqualTo(account.getId());
            mapper.updateByExample(account,example);
        }
    }


}
