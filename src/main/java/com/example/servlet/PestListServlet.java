package com.example.servlet;

import com.alibaba.fastjson.JSON;
import com.example.service.DocumentService;
import com.example.service.impl.DocumentServiceImpl;
import com.example.utils.ResultInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author youngoo
 */
@WebServlet(name = "PestListServlet", value = "/pestList.do")
public class PestListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        DocumentService documentService = new DocumentServiceImpl();
        ResultInfo result = documentService.getPestListList(page, limit);
        response.getWriter().write(JSON.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
