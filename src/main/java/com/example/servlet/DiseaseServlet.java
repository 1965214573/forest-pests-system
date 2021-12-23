package com.example.servlet;

import com.example.entities.Query.QueryDisease;
import com.example.entities.Query.QueryPest;
import com.example.service.DiseaseService;
import com.example.service.PestService;
import com.example.service.impl.DiseaseServiceImpl;
import com.example.service.impl.PestServiceImpl;
import com.example.utils.ResultInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author youngoo
 * @date 2021/12/23 21:38
 */
@WebServlet(name = "diseaseServlet", urlPatterns = "/disease/*")
public class DiseaseServlet extends BaseServlet{
    public ResultInfo getDiseaseList(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String symptom = request.getParameter("symptom");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        if (page == null || limit == null) {
            return ResultInfo.err();
        } else {
            QueryDisease queryDisease = new QueryDisease(name, symptom, (Integer.parseInt(page) - 1) * Integer.parseInt(limit), Integer.parseInt(limit));
            DiseaseService diseaseService = new DiseaseServiceImpl();
            return diseaseService.queryList(queryDisease);
        }
    }
}
