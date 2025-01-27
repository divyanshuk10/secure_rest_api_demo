package com.divyanshu.rest_api_demo.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class CustomRequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String url = ((HttpServletRequest) request).getRequestURL().toString();

        System.out.println("Before : " + url);
        chain.doFilter(request, response);
        System.out.println("After : " + url);

    }
}
