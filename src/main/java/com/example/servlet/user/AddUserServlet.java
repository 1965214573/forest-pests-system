package com.example.servlet.user;

import com.alibaba.fastjson.JSON;
import com.example.entities.PO.User;
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
@WebServlet(name = "AddUserServlet", value = "/user/addUser.do")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 封装参数 todo 未进行非空判断等数据验证
        User userInfo = User.builder()
                .userName(request.getParameter("userName"))
                .userPwd(request.getParameter("userPwd"))
                .realName(request.getParameter("realName"))
                .build();
        int role = Integer.parseInt(request.getParameter("role")) ;
        UserService userService = new UserServiceImpl();
        ResultInfo resultInfo = userService.addUser(userInfo, role);
        response.getWriter().write(JSON.toJSONString(resultInfo));
    }
}
