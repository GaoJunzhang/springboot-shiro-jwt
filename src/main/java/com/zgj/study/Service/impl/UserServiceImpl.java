package com.zgj.study.Service.impl;

import com.zgj.study.Service.IUserService;
import com.zgj.study.dao.UserJpaRepository;
import com.zgj.study.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* class_name: UserServiceImpl
* package: com.zgj.study.Service.impl
* describe: 接口继承类
* creat_user: ZhangGaoJun@zhanggj@seeyoo.cn
* creat_date: 2018/3/20
* creat_time: 8:52
**/
@Service
@Transactional
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserJpaRepository userJpaRepository;


    public List<User> findAll()
    {
        return userJpaRepository.findAll();
    }

    public List<User> findByName(String name)
    {
        List<User> userList1 = userJpaRepository.findByName1(name);
        List<User> userList2 = userJpaRepository.findByName2(name);
        List<User> userList3 = userJpaRepository.findByNameAndAddress(name, "3");
        System.out.println("userList1:" + userList1);
        System.out.println("userList2:" + userList2);
        System.out.println("userList3:" + userList3);
        return userJpaRepository.findByName(name);
    }

    public void saveUser(User book)
    {
        userJpaRepository.save(book);
    }

    @Cacheable("users")
    public User findOne(long id)
    {
        System.out.println("Cached Pages");
//        return userJpaRepository.findOne(id);
        return userJpaRepository.getOne(id);
    }

    public void delete(long id)
    {
//        userJpaRepository.delete(id);
        userJpaRepository.deleteById(id);
    }
    public User findByAccount(String account){
        return userJpaRepository.findByAccount(account);
    }
}
