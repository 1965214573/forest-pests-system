package com.example.fliter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author youngoo
 */
@WebFilter(filterName = "CharacterEncodeFilter", urlPatterns = "*.do")
public class CharacterEncodeFilter implements Filter {
    Logger logger = Logger.getLogger(CharacterEncodeFilter.class);
    @Override
    public void init(FilterConfig config) {
        System.out.println("字符编码过滤器初始化成功");
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ((HttpServletResponse) response).setHeader("Content-Type", "application/json; charset=utf-8");
        logger.debug("设置响应内容：Content-Type: application/json; charset=utf-8");
        chain.doFilter(request, response);
    }
}
