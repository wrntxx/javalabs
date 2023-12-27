package com.education.ztu;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        String url = req instanceof HttpServletRequest ? ((HttpServletRequest) req).getRequestURL().toString() : "N/A";
        System.out.println("Request URL: " + url);
        chain.doFilter(req, res);
    }
}
