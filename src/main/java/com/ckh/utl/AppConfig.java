package com.ckh.utl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by CKH on 2017/6/9 14:23.
 */
@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{
//    InternalResourceViewResolver
//　　视图名称解析器
    @Bean
    public InternalResourceViewResolver viewResolver() {
//        <!-- configure the InternalResourceViewResolver -->
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        前缀
        internalResourceViewResolver.setPrefix("/");
//        后缀
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
//        super.configureDefaultServletHandling(configurer);
    }
}
