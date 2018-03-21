package com.zgj.study.Service;

import com.zgj.study.model.Menu;

import java.util.List;

/**
 * Created by user on 2018/3/21.
 */
public interface IMenuService {
    public List<Menu> loadUserMenu(String account);
}
