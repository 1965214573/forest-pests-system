package com.example.servlet;

import com.alibaba.fastjson.JSON;
import com.example.utils.ResultInfo;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author youngoo
 * @date 2021/12/22 15:23
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger logger = Logger.getLogger(this.getClass());
        String uri = req.getRequestURI();
        String methodName = uri.lastIndexOf('?') != -1 ? uri.substring(uri.lastIndexOf('/') + 1, uri.lastIndexOf('?')) : uri.substring(uri.lastIndexOf('/') + 1);
        System.out.println(methodName);
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.debug(e.getMessage());
            resp.getWriter().write(JSON.toJSONString(ResultInfo.err()));
        }
    }
}
