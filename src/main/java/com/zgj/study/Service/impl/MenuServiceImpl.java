package com.zgj.study.Service.impl;

import com.zgj.study.Service.IMenuService;
import com.zgj.study.dao.MenuJpaRepository;
import com.zgj.study.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2018/3/21.
 */
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuJpaRepository menuJpaRepository;

    public List<Menu> loadUserMenu(String account){
        return null;
    }
}
