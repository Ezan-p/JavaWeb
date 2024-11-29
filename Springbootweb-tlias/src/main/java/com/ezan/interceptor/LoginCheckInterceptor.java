package com.ezan.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.ezan.pojo.Result;
import com.ezan.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override //目标资源方法运行前运行，放行则返回true
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取请求的URL
        String url = request.getRequestURL().toString();
        log.info("请求的URL： {}",url);

        //2.判断请求的URL是否包含Login，包含则放行（return true）
        if(url.contains("login")){
            log.info("登录操作，放行");
            return true;
        }

        //3.获取请求头中的令牌token
        String jwt = request.getHeader("token");        //获取的是请求头

        //4.判断令牌是否存在，不存在则不放行（return false）
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        //5.解析令牌，解析失败则不放行
        try{
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析token失败，返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }


        //6.放行
        log.info("令牌合法，放行");
        return true;
    }

    @Override   //目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override   //视图渲染完毕后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
