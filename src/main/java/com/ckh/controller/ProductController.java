package com.ckh.controller;

import com.ckh.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by CKH on 2017/6/9 19:51.
 * 控制器ProductController，准备一个add方法映射/addProduct路径
 *
 * 为add方法准备一个Product 参数，用于接收注入
 *
 * 最后跳转到showProduct页面显示用户提交的数据
 */
@Controller
@RequestMapping("/")
public class ProductController {
    @RequestMapping("addProduct")
    public ModelAndView add(Product product) throws Exception {
        return new ModelAndView("showProduct");
    }
    @RequestMapping(value="addVacate")
    public void addVacate(Product product/*, HttpServletRequest req, HttpServletResponse resp*/){
        System.out.println(product.getName());//
        System.out.println(product.getPrice());
    }
}
