package com.main.entity;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 *
 * @ClassName: MyFilter
 * @Description:自定义过滤器
 * @author cheng
 * @date 2017年9月26日 上午9:19:38
 */
// 加入spring ioc容器
@Component
/*
 * @WebFilter将一个实现了javax.servlet.Filter接口的类定义为过滤器
 * 属性filterName声明过滤器的名称,可选
 * 属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 */
@WebFilter(filterName = "corsFilter", urlPatterns = "/*")
//指定过滤器的执行顺序,值越小越靠后执行
public class CorsFilter implements Filter {

    /**
     * 执行过滤操作
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("执行过滤操作。。。111");


        HttpServletResponse res= (HttpServletResponse) response;

        HttpServletRequest reqs = (HttpServletRequest) request;

        System.out.println(reqs);

        String []  allowDomain= {"http://127.0.0.1:4040","http://localhost:4040"};
        Set allowedOrigins= new HashSet(Arrays.asList(allowDomain));
        String originHeader=((HttpServletRequest) reqs).getHeader("Origin");
        System.out.println(originHeader);
        String method = reqs.getMethod();

        if(method == "OPTIONS"){
            return;
        }


        if (allowedOrigins.contains(originHeader)){
            // response.setHeader("Access-Control-Allow-Origin",reqs.getHeader("Origin"));
            res.setHeader("Access-Control-Allow-Origin", originHeader);
//            res.setHeader("Content-Type","application/json; charset=utf-8");
            res.setHeader("Access-Control-Allow-Credentials", "true");
            res.setHeader("Access-Control-Allow-Methods", "POST, GET");
            res.setHeader("Access-Control-Max-Age", "3600");
            res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        }else{
            ((HttpServletResponse) response).setStatus(403);
        }

        chain.doFilter(request, response);
    }

    /**
     * 过滤器初始化
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化。。。111");
    }

    /**
     * 过滤器销毁
     */
    @Override
    public void destroy() {
        System.out.println("过滤器销毁。。。111");
    }

}
