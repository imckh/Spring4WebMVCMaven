package com.ckh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by CKH on 2017/6/9 21:09.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", "hello Spring MVC");
        return modelAndView;
    }
    @RequestMapping("/jump")
    public ModelAndView jump() {
        return new ModelAndView("redirect:/hello");
    }

    /**
     * 映射 /check 到方法check()
     * 为方法check()提供参数HttpSession session，这样就可以在方法体中使用session了
     * 接下来的逻辑就是每次访问为session中的count+1.
     * 最后跳转到check.jsp页面
     * @param httpSession 为方法check()提供参数HttpSession session
     * @return ModelAndView
     */
    @RequestMapping("/check")
    public ModelAndView check(HttpSession httpSession) {
        Integer i = (Integer) httpSession.getAttribute("count");
        if (i == null)
            i = 0;
        i++;
        httpSession.setAttribute("count", i);
        return new ModelAndView("check");
    }
}
