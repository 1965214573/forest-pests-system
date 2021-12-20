package com.example.servlet;

import com.alibaba.fastjson.JSON;
import com.example.entities.PO.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.example.utils.ResultInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author youngoo
 */
@WebServlet(name = "LoginServlet", value = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 数据验证

        String code = Calendar.getInstance().toString();
        code = (String) request.getSession().getAttribute("code");
        System.out.println(code);
        if (!code.equalsIgnoreCase(request.getParameter("vercode"))) {
            System.out.println(ResultInfo.err());
            response.getWriter().write(JSON.toJSONString(ResultInfo.builder()
                    .code(400)
                    .msg("验证码有误")
                    .build()));
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = User.builder().userName(username).userPwd(password).build();
            UserService userService = new UserServiceImpl();
            ResultInfo resultInfo= userService.unSafeLogin(user);
            response.getWriter().write(JSON.toJSONString(resultInfo));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
