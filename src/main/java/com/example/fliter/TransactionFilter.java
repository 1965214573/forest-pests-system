package com.example.fliter;

import com.example.utils.MybatisUtil;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author youngoo
 */
@WebFilter(filterName = "TransactionFilter", urlPatterns = "/*")
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(request, response);
            MybatisUtil.commitTransaction();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(this.getClass());
            logger.error("操作失败", e);
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }
}
