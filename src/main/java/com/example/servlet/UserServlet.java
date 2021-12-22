package com.example.servlet;

import com.alibaba.fastjson.JSON;
import com.example.entities.PO.User;
import com.example.service.CommonService;
import com.example.service.UserService;
import com.example.service.impl.CommonServiceImpl;
import com.example.service.impl.UserServiceImpl;
import com.example.utils.ResultInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author youngoo
 * @date 2021/12/22 15:30
 */
@WebServlet(name = "userServlet", urlPatterns = "/user.do/*")
public class UserServlet extends BaseServlet{

    public ResultInfo login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 数据验证

        String code = Calendar.getInstance().toString();
        code = (String) request.getSession().getAttribute("code");
        if (!code.equalsIgnoreCase(request.getParameter("vercode"))) {
            return ResultInfo.builder()
                    .code(400)
                    .msg("验证码有误")
                    .build();
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = User.builder().userName(username).userPwd(password).build();
            UserService userService = new UserServiceImpl();
            return userService.unSafeLogin(user);
        }
    }

    public ResultInfo getMenu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        System.out.println(userId);
        CommonService commonService = new CommonServiceImpl();
        User user = User.builder().userId(Integer.valueOf(userId)).build();
        return commonService.showMenuList(user);
    }

    public ResultInfo userList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        UserService userService = new UserServiceImpl();
        return userService.getUserList(page, limit);
    }

    public ResultInfo roleList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = new UserServiceImpl();
        return userService.getRoleList();
    }

    public ResultInfo addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 封装参数 todo 未进行非空判断等数据验证
        User userInfo = User.builder()
                .userName(request.getParameter("userName"))
                .userPwd(request.getParameter("userPwd"))
                .realName(request.getParameter("realName"))
                .build();
        int role = Integer.parseInt(request.getParameter("role"));
        UserService userService = new UserServiceImpl();
        return userService.addUser(userInfo, role);
    }
}
