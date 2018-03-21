package com.zgj.study.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2018/3/21.
 */
@Entity
@Table(name = "role_menu")
@Getter
@Setter
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = -6596692230376300358L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "menu_id")
    private Integer menuId;
}
