package com.example.servlet.user;

import com.alibaba.fastjson.JSON;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.example.utils.ResultInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author youngoo
 */
@WebServlet(name = "RoleListServlet", value = "/roleList.do")
public class RoleListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        ResultInfo resultInfo = userService.getRoleList();
        response.getWriter().write(JSON.toJSONString(resultInfo));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
