package com.zgj.study.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by user on 2018/3/20.
 */
@Getter@Setter
public class AudienceBean {
    private String clientId;
    private String expiresSecond;
    private String base64Secret;
}
