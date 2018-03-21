package com.zgj.study.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by user on 2018/3/20.
 */
@Entity
@Table(name = "role")
@Getter
@Setter
public class Role implements Serializable{
    private static final long serialVersionUID = -8796666876078265069L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private Integer id;

    @Column(name = "role_name", length = 24)
    private String roleName;

    @Column(name = "enable", length = 4)
    private short enable;

}
