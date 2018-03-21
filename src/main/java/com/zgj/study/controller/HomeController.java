package com.zgj.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by user on 2018/3/21.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String helloHtml(Map<String,Object> map){

        map.put("hello","from TemplateController.helloHtml");
        return"/index";
    }
}
