package com.example.servlet.user;

import com.alibaba.fastjson.JSON;
import com.example.entities.PO.User;
import com.example.service.CommonService;
import com.example.service.impl.CommonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author youngoo
 * @date 2021/12/11 18:32
 */
@WebServlet(name = "MenuServlet", urlPatterns = "/menu.do")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        System.out.println(userId);
        CommonService commonService = new CommonServiceImpl();
        User user = User.builder().userId(Integer.valueOf(userId)).build();
        resp.getWriter().write(JSON.toJSONString(commonService.showMenuList(user)));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
