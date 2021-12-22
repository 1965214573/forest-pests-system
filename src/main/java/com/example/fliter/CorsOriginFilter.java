package com.example.fliter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author youngoo
 */
@WebFilter(filterName = "CorsOriginFilter", urlPatterns = "/*")
public class CorsOriginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // 允许跨域的主机地址
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        httpResponse.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        httpResponse.setHeader("Access-Control-Max-Age", "4200");
        /* 允许跨域的请求头 */
        httpResponse.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(request, response);
    }
}
