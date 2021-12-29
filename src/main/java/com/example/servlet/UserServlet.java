package com.example.servlet;

import com.example.entities.PO.User;
import com.example.entities.Query.QueryLog;
import com.example.entities.Query.QueryUser;
import com.example.service.CommonService;
import com.example.service.UserService;
import com.example.service.impl.CommonServiceImpl;
import com.example.service.impl.UserServiceImpl;
import com.example.utils.Action;
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

    @Action("登录")
    public ResultInfo login(HttpServletRequest request, HttpServletResponse response) {
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
            return userService.unSafeLogin(user, request);
        }
    }

    @Action("获取菜单信息")
    public ResultInfo getMenu(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("userId");
        System.out.println(userId);
        CommonService commonService = new CommonServiceImpl();
        User user = User.builder().userId(Integer.valueOf(userId)).build();
        return commonService.showMenuList(user);
    }

    @Action("查看用户信息")
    public ResultInfo userList(HttpServletRequest request, HttpServletResponse response) {
        String roleId = request.getParameter("roleId");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        QueryUser queryUser = new QueryUser(roleId == null ? null : Integer.parseInt(roleId),
                page == null ? null : (Integer.parseInt(page) - 1) * Integer.parseInt(limit),
                limit == null ? null : Integer.parseInt(limit)
        );

        UserService userService = new UserServiceImpl();
        // return userService.getUserList(page, limit);
        return userService.getUserList(queryUser);
    }

    public ResultInfo roleList(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserServiceImpl();
        return userService.getRoleList();
    }

    @Action("添加用户")
    public ResultInfo addUser(HttpServletRequest request, HttpServletResponse response) {
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

    @Action("修改用户信息")
    public ResultInfo updateUser(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String realName = request.getParameter("realName");
        String roleId = request.getParameter("roleId");
        User user = new User(Integer.parseInt(id), userName, userPwd, realName, 0);
        UserService userService = new UserServiceImpl();
        return userService.updateUser(user, Integer.parseInt(roleId));
    }

    @Action("删除用户")
    public ResultInfo delUser(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("id");
        UserService userService = new UserServiceImpl();
        return userService.delUser(Integer.parseInt(userId));
    }

    @Action("查看日志")
    public ResultInfo getLogList(HttpServletRequest request, HttpServletResponse response) {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        QueryLog queryLog = new QueryLog(startDate, endDate,
                page == null ? null : (Integer.parseInt(page) - 1) * Integer.parseInt(limit),
                limit == null ? null : Integer.parseInt(limit)
        );
        CommonService commonService = new CommonServiceImpl();
        return commonService.queryLog(queryLog);
    }
}
