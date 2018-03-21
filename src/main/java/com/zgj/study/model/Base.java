package com.zgj.study.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by user on 2018/3/21.
 */
@Data
@MappedSuperclass
public class Base implements Serializable {
    private static final long serialVersionUID = -6718838800112233445L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    private Long id;// ID
    @Column(name = "create_time",length = 19)
    private Timestamp createTime;// 创建日期
    @Column(name = "update_time",length = 19)
    private Timestamp updateTime;// 修改日期
    @Column(name = "delete_time",length = 19)
    private Timestamp deleteTime;
    @Column(name = "is_delete",length = 4)
    private Short isDelete;
}
