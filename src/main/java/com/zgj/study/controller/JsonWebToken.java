package com.zgj.study.controller;

import com.zgj.study.Service.IUserService;
import com.zgj.study.bean.TokenBean;
import com.zgj.study.config.Audience;
import com.zgj.study.model.User;
import com.zgj.study.result.JsonResult;
import com.zgj.study.result.ResultCode;
import com.zgj.study.util.JwtHelper;
import com.zgj.study.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 2018/3/20.
 */
@RestController
public class JsonWebToken {
    @Autowired
    private IUserService userService;

    @Autowired
    private Audience audienceEntity;

    @RequestMapping("oauth/token")
    public Object getAccessToken(@RequestBody User user) {
        JsonResult jsonResult;
        if (StringUtils.isEmpty(user.getAccount())) {
            jsonResult = new JsonResult(ResultCode.PARAMS_ERROR, "账号为空", null);
            return jsonResult;
        }
        User userInfo = userService.findByAccount(user.getAccount());
        if (userInfo == null) {
            jsonResult = new JsonResult(ResultCode.NOT_LOGIN, "账号错误", null);
            return jsonResult;
        } else {
            String md5Password = MD5Util.encode(user.getPassword());

            if (md5Password.compareTo(userInfo.getPassword()) != 0) {
                jsonResult = new JsonResult(ResultCode.NOT_LOGIN, "密码错误", null);
                return jsonResult;
            }
        }
        //拼装accessToken
        String accessToken = JwtHelper.createJWT(user.getAccount(), String.valueOf(user.getName()),
                "", audienceEntity.getClientId(), audienceEntity.getName(),
                audienceEntity.getExpiresSecond() * 1000, audienceEntity.getBase64Secret());
        //返回accessToken
        TokenBean tokenBean = new TokenBean();
        tokenBean.setAccess_token(accessToken);
        tokenBean.setExpires_in(audienceEntity.getExpiresSecond());
        tokenBean.setToken_type("bearer");
        jsonResult = new JsonResult(ResultCode.SUCCESS, "登录成功", tokenBean);
        return jsonResult;
    }
}
