package com.example.fliter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author youngoo
 */
@WebFilter(filterName = "CharacterEncodeFilter", urlPatterns = "*.do")
public class CharacterEncodeFilter implements Filter {
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
        System.out.println("已设置编码");
        chain.doFilter(request, response);
    }
}
