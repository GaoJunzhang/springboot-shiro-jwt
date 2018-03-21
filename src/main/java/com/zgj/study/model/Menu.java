package com.zgj.study.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by user on 2018/3/21.
 */
@Entity
@Table(name = "menu")
@Setter
@Getter
public class Menu implements Serializable{

    private static final long serialVersionUID = 3119291104311675482L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    private Integer id;
    @Column(name = "name",length = 50)
    private String name;
    @Column(name = "url",length = 200)
    private String url;
    @Column(name = "type",length = 4)
    private Short type;
    @Column(name = "pid")
    private Integer pid;
    @Column(name = "sort",length = 10)
    private Integer sort;
    @Column(name = "enable",length = 4)
    private Short enable;
    @Column(name = "icon",length = 100)
    private String icon;

}
