package com.tu.common.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by len on 2019/1/18.
 */
public class UserFilter implements Filter {


    //初始化
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //拦截逻辑
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    //销毁
    public void destroy() {

    }
}
