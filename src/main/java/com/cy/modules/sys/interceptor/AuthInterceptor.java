package com.cy.modules.sys.interceptor;

/**
 * Created by kam on 2015/10/18.
 */

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * springmvc拦截类
 */
@Component("SpringMVCInterceptor")
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //过滤登录操作、用户操作
        String[] noFilters = new String[]{"user", "login"};
        String uri = request.getRequestURI();
        boolean beFilter = true;
        for (String s : noFilters) {
            if (uri.indexOf(s) != -1) {
                beFilter = false;
                break;
            }
        }
        if (beFilter) {
            if (request.getSession().getAttribute("user") == null) {
                //ajax方式交互
                if (request.getHeader("x-requested-with") != null
                        && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))// 如果是ajax请求响应头会有，x-requested-with；
                {
                    response.setHeader("sessionstatus", "timeout");// 在响应头设置session状态
                    return false;
                }
                // 未登录
                PrintWriter out = response.getWriter();
                StringBuilder builder = new StringBuilder();
                builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
                builder.append("alert(\"登录超时，请重新登录！\");");
                builder.append("window.top.location.href='/enterprise/login/logout.do';");
                builder.append("</script>");
                out.print(builder.toString());
                out.close();
                return false;
            } else {
                // 系统日志操作
                // -----------------------------------
                // -----------------------------------
            }
        }
        Map paramsMap = request.getParameterMap();
        return super.preHandle(request, response, handler);
    }
}