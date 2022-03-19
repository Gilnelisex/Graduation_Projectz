package com.example.demo.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminConfig implements WebMvcConfigurer {

    @Bean
    public AdminInterceptor adminInterceptorx() {
        return new AdminInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(adminInterceptorx());
        registration.addPathPatterns(
                "/personalCenter",
                "/changeUsers",
                "/uploadImage",
                "/changePassword",
                "/getOrderManage"
        );
        registration.excludePathPatterns(                         //添加不拦截路径
                "/**/*.html",            //html静态资源
                "/**/*.js",              //js静态资源
                "/**/*.css"             //css静态资源
        );
    }
}