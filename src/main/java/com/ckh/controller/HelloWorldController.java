package com.ckh.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by CKH on 2017/6/9 15:22.
 * 开发处理器/页面控制器
 */
//org.springframework.web.servlet.mvc.Controller：页面控制器/处理器必须实现Controller接口，注意别选错了
public class HelloWorldController implements Controller {
//  功能处理方法，实现相应的功能处理，比如收集参数、验证参数、绑定参数到命令对象、将命令对象传入业务对象进行业务处理、最后返回ModelAndView对象；
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //1、收集参数、验证参数
        //2、绑定参数到命令对象
        //3、将命令对象传入业务对象进行业务处理
        //4、选择下一个页面
//        包含了视图要实现的模型数据和逻辑视图名
        ModelAndView modelAndView = new ModelAndView();
        // 添加模型数据, 可以是任意POJO对象
        modelAndView.addObject("message", "HelloWorld");
//      表示设置逻辑视图名为“hello”，视图解析器会将其解析为具体的视图，
//      如前边的视图解析器InternalResourceVi。wResolver会将其解析为“WEB-INF/jsp/hello.jsp”。
        modelAndView.setViewName("hello");
        return modelAndView;
//        我们需要将其添加到Spring配置文件(WEB-INF/spring-servlet.xml)，让其接受Spring IoC容器管理
    }
}
