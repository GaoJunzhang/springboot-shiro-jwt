package com.zgj.study.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by user on 2018/3/19.
 */
//@NamedQuery(name = "User.findByName", query = "select name,address from User u where u.name=?1")
@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends Base {
    private static final long serialVersionUID = -576773477833902195L;
    @Column(name = "name", length = 50)
    String name;
    @Column(name = "address", length = 50)
    String address;
    @Column(name = "account", length = 50, unique = true, nullable = false)
    private String account;
    @Column(name = "password", length = 50)
    private String password;
    @Column(name = "mac",length = 64)
    private String mac;
    @Column(name = "enable",length = 4)
    private Short enable;
}
