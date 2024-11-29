package com.ezan.filter;

import com.alibaba.fastjson.JSONObject;
import com.ezan.pojo.Result;
import com.ezan.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将请求响应强转HTTP
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //1.获取请求URL
        String url = req.getRequestURL().toString();
        log.info("请求的URL：{}",url);

        //2.判断请求的URL中是否包含login，如果包含，说明是登录操作，则放行
        if(url.contains("login")){
            log.info("登录操作，放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //3.获取请求头中的令牌(token)
        String jwt = req.getHeader("token");

        //4.判断令牌是否存在，如果不存在，则返回错误
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头Token为空，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换对象-->json-------用阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        //5.解析令牌，如果解析失败，则返回错误结果
        try{
            JwtUtils.parseJWT(jwt);
        } catch (Exception e){
            //如果解析失败
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            ////手动转换对象-->json-------用阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        //6.放行
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
