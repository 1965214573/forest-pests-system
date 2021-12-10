package com.example.servlet;

import com.example.entities.VO.MenuVO;
import com.example.service.CommonService;
import com.example.service.impl.CommonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author youngoo
 */
@WebServlet(name = "LoginServlet", value = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("登录成功");
        CommonService commonService = new CommonServiceImpl();
        List<MenuVO> menuVOList = commonService.showMenuList(1);
        menuVOList.forEach(System.out::println);
        request.getSession().setAttribute("msg", "登录成功");
        request.getSession().setAttribute("menuVOList", menuVOList);
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
