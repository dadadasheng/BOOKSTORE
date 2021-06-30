package com.example.bookstore.Filter;

import com.example.bookstore.Services.TokenService.TokenService;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/getUserInfo/*")
public class IndexFilter implements Filter {
    @Resource
    TokenService tokenService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
//        ServletContext servletContext = filterConfig.getServletContext();
//        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//        tokenServiceTest = ctx.getBean("TokenService",TokenServiceImp.class);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入了过滤器");
        //校验用户登录状态
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //Filter过滤器跨域处理
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String token = request.getHeader("token");
        if(tokenService.getPhoneByToken(token)!=null) {
            System.out.println("我是过滤器获取的" + tokenService.getPhoneByToken(token));
            filterChain.doFilter(request,response);
        }else{
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
