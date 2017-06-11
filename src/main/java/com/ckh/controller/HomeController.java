package com.ckh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller 负责注册一个bean 到spring 上下文中
@Controller
@RequestMapping("/")
public class HomeController {
//    RequestMapping 注解为控制器指定可以处理哪些 URL 请求
    @RequestMapping(value = "/test")
    public String  home() {
        return "test";
    }
    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
