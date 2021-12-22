package com.example.servlet;

import com.alibaba.fastjson.JSON;
import com.example.entities.Query.QueryPest;
import com.example.service.PestService;
import com.example.service.impl.PestServiceImpl;
import com.example.utils.ResultInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author youngoo
 * @date 2021/12/22 18:20
 */
@WebServlet(urlPatterns = "/pest/*")
public class PestServlet extends BaseServlet{

    public ResultInfo getPestList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pestName = request.getParameter("pestName");
        String host = request.getParameter("host");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String test = request.getParameter("test");
        if (page == null || limit == null) {
            return ResultInfo.err();
        } else {
            QueryPest queryPest = new QueryPest(pestName, host, (Integer.parseInt(page) - 1) * Integer.parseInt(limit), Integer.parseInt(limit));
            PestService pestService = new PestServiceImpl();
            return pestService.queryList(queryPest);
        }

    }
}
