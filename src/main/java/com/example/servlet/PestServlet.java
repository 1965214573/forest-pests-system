package com.example.servlet;

import com.alibaba.fastjson.JSON;
import com.example.entities.PO.Pest;
import com.example.entities.Query.QueryPest;
import com.example.service.PestService;
import com.example.service.impl.PestServiceImpl;
import com.example.utils.ResultInfo;
import com.example.utils.SnowIdUtils;

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

        if (page == null || limit == null) {
            return ResultInfo.err();
        } else {
            QueryPest queryPest = new QueryPest(pestName, host, (Integer.parseInt(page) - 1) * Integer.parseInt(limit), Integer.parseInt(limit));
            PestService pestService = new PestServiceImpl();
            return pestService.queryList(queryPest);
        }
    }

    public ResultInfo addPest(HttpServletRequest request, HttpServletResponse response) {
        String pestName = request.getParameter("pestName");
        String host = request.getParameter("host");
        String breed = request.getParameter("breed");
        String enemy = request.getParameter("enemy");
        String damage = request.getParameter("damage");
        String measure = request.getParameter("measure");
        String childPicture = request.getParameter("childPicture");
        String adultPicture = request.getParameter("adultPicture");
        long id = SnowIdUtils.uniqueLong();
        Pest pest = new Pest(id, pestName, host, breed, enemy, damage, measure, childPicture, adultPicture);
        PestService pestService = new PestServiceImpl();
        return pestService.addPest(pest);
    }

    public ResultInfo delPest(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            long id = Long.parseLong(idStr);
            PestService pestService = new PestServiceImpl();
            return pestService.delPestById(id);
        }
        return ResultInfo.builder()
                .code(400)
                .msg("参数异常")
                .build();
    }
}
