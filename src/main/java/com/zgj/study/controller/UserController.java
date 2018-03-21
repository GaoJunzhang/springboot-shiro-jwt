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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by user on 2018/3/20.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

//    @Autowired
//    private Audience audienceEntity;
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
//    public JsonResult login(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> map, @RequestBody User user1) {
//        User user = userService.findByAccount(map.get("userName"));
//        if (user == null) {
//            return new JsonResult(ResultCode.NOT_LOGIN, "账号不存在");
//        }
//        if (user.getAccount().equals(map.get("userName")) && user.getPassword().equals(map.get("password"))) {
//            return new JsonResult(ResultCode.SUCCESS, "登录成功！", null);
//        } else {
//            return new JsonResult(ResultCode.NOT_LOGIN, "登录失败！", null);
//        }
//    }

    @RequestMapping(value = "/user")
    public JsonResult user(@RequestBody User user){
        User userInfo = userService.findByAccount(user.getAccount());
        return new JsonResult(ResultCode.SUCCESS,"success",userInfo);
    }


}
