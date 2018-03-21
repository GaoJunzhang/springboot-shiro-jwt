package com.zgj.study.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2018/3/21.
 */
@Entity
@Table(name = "user_role")
@Getter
@Setter
public class UserRole implements Serializable {

    private static final long serialVersionUID = 3323720287320635019L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "role_id")
    private Integer roleId;

}
