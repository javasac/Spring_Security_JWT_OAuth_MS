package com.sachin.SecurityJWT.security;
import jakarta.servlet.*;
import org.springframework.web.filter.GenericFilterBean;
import java.io.IOException;

public class MySecurityFilter implements Filter
//public class MySecurityFilter extends GenericFilterBean
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException
    {
        System.out.println("=====Before=====");
        chain.doFilter(req, res);
        System.out.println("=====After=====");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
