package com.example.servlet;

import com.example.entities.PO.Area;
import com.example.entities.Query.QueryArea;
import com.example.service.AreaService;
import com.example.service.impl.AreaServiceImpl;
import com.example.utils.ResultInfo;
import com.example.utils.SnowIdUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author youngoo
 * @date 2021/12/24 15:19
 */
@WebServlet(name = "areaServlet", urlPatterns = "/area/*")
public class AreaServlet extends BaseServlet{

    public ResultInfo getLandList(HttpServletRequest request, HttpServletResponse response) {
        AreaService areaService = new AreaServiceImpl();
        return areaService.queryLandTypeList();
    }

    public ResultInfo addArea(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String forestType = request.getParameter("forestType");
        String dominantTree = request.getParameter("dominantTree");
        String landType = request.getParameter("landType");
        long id = SnowIdUtils.uniqueLong();

        Area area = new Area(id, name, forestType, landType, dominantTree);
        AreaService areaService = new AreaServiceImpl();
        return areaService.addArea(area);
    }

    public ResultInfo getAreaList(HttpServletRequest request, HttpServletResponse response) {
        // 处理查询条件
        String name = request.getParameter("name");
        String forestType = request.getParameter("forestType");
        String classId = request.getParameter("classId");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        QueryArea queryArea = new QueryArea(name, forestType, (classId == null || classId.equals("")) ? null : Long.parseLong(classId), (Integer.parseInt(page) - 1) * Integer.parseInt(limit), Integer.parseInt(limit));
        AreaService areaService = new AreaServiceImpl();
        return areaService.queryAreaList(queryArea);
    }

    public ResultInfo getNoClassArea(HttpServletRequest request, HttpServletResponse response) {
        AreaService areaService = new AreaServiceImpl();
        return areaService.queryNoClassArea();
    }
}
