package com.example.demo.interceptor;

import com.example.demo.domain.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    UsersService usersService;

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//        System.out.println("执行了TestInterceptor的preHandle方法");
        //统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
        Users users = (Users) request.getSession().getAttribute("users");
        if (users != null) {
            Users user = usersService.selectByPrimaryKey(users.getId());
            if (users.getUserstatus() == 1) {
                request.getSession().setAttribute("users", user);
                return true;
            } else {
                response.sendRedirect("/logout");
                return false;
            }
        } else {
            response.sendRedirect("/logout");
            return false;//如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
            //如果设置为true时，请求将会继续执行后面的操作
        }
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//         System.out.println("执行了TestInterceptor的postHandle方法");
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        System.out.println("执行了TestInterceptor的afterCompletion方法");
    }

}
