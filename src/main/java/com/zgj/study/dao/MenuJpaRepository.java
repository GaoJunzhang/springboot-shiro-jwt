package com.zgj.study.dao;

import com.zgj.study.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2018/3/21.
 */
public interface MenuJpaRepository extends JpaRepository<Menu,Integer> {

}
