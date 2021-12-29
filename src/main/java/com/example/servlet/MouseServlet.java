package com.example.servlet;

import com.example.entities.PO.Disease;
import com.example.entities.PO.Mouse;
import com.example.entities.Query.QueryDisease;
import com.example.entities.Query.QueryMouse;
import com.example.service.DiseaseService;
import com.example.service.MouseService;
import com.example.service.impl.DiseaseServiceImpl;
import com.example.service.impl.MouseServiceImpl;
import com.example.utils.Action;
import com.example.utils.ResultInfo;
import com.example.utils.SnowIdUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author youngoo
 * @date 2021/12/23 21:38
 */
@WebServlet(name = "mouseServlet", urlPatterns = "/mouse/*")
public class MouseServlet extends BaseServlet{

    @Action("查看鼠害列表")
    public ResultInfo getMouseList(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        if (page == null || limit == null) {
            return ResultInfo.err();
        } else {
            QueryMouse queryMouse = new QueryMouse(name, (Integer.parseInt(page) - 1) * Integer.parseInt(limit), Integer.parseInt(limit));
            MouseService mouseService = new MouseServiceImpl();
            return mouseService.queryList(queryMouse);
        }
    }

    @Action("添加鼠害信息")
    public ResultInfo addMouse(HttpServletRequest request, HttpServletResponse response) {
        // 处理参数
        String name = request.getParameter("name");
        String food = request.getParameter("food");
        String breed = request.getParameter("breed");
        String pictureUrl = request.getParameter("pictureUrl");
        String enemy = request.getParameter("enemy");
        String damage = request.getParameter("damage");
        String measure = request.getParameter("measure");
        long id = SnowIdUtils.uniqueLong();
        Mouse mouse = new Mouse(id, name, food, breed, pictureUrl, enemy, damage, measure);
        MouseService mouseService = new MouseServiceImpl();
        return mouseService.addMouse(mouse);
    }

    @Action("删除鼠害信息")
    public ResultInfo delMouse(HttpServletRequest request, HttpServletResponse response) {
        // 处理参数
        String idStr = request.getParameter("id");
        long id = Long.parseLong(idStr);

        MouseService mouseService = new MouseServiceImpl();
        return mouseService.delMouse(id);
    }
}
