package com.example.servlet;

import com.example.entities.PO.Disease;
import com.example.entities.Query.QueryDisease;
import com.example.entities.Query.QueryPest;
import com.example.service.DiseaseService;
import com.example.service.PestService;
import com.example.service.impl.DiseaseServiceImpl;
import com.example.service.impl.PestServiceImpl;
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
@WebServlet(name = "diseaseServlet", urlPatterns = "/disease/*")
public class DiseaseServlet extends BaseServlet{
    @Action("查看病害")
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

    @Action("添加病害")
    public ResultInfo addDisease(HttpServletRequest request, HttpServletResponse response) {
        // 处理参数
        String name = request.getParameter("name");
        String cause = request.getParameter("cause");
        String symptom = request.getParameter("symptom");
        String pictureUrl = request.getParameter("pictureUrl");
        String pathogenesis = request.getParameter("pathogenesis");
        String damage = request.getParameter("damage");
        String measure = request.getParameter("measure");
        long id = SnowIdUtils.uniqueLong();
        Disease disease = new Disease(id, name, cause, symptom, pictureUrl, pathogenesis, damage, measure);
        DiseaseService diseaseService = new DiseaseServiceImpl();
        return diseaseService.addDisease(disease);
    }

    @Action("删除病害")
    public ResultInfo delDisease(HttpServletRequest request, HttpServletResponse response) {
        // 处理参数
        String idStr = request.getParameter("id");
        long id = Long.parseLong(idStr);

        DiseaseService diseaseService = new DiseaseServiceImpl();
        return diseaseService.delDisease(id);
    }
}
