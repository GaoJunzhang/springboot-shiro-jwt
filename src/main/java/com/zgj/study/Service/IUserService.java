package com.zgj.study.Service;

import com.zgj.study.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* class_name: IUserService
* package: com.zgj.study.Service
* describe: 接口类
* creat_user: ZhangGaoJun@zhanggj@seeyoo.cn
* creat_date: 2018/3/20
* creat_time: 8:53
**/

public interface IUserService {
    public List<User> findAll();

    public void saveUser(User book);

    public User findOne(long id);

    public void delete(long id);

    public List<User> findByName(String name);

    public User findByAccount(String account);
}
