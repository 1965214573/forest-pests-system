package com.example.servlet;

import com.example.entities.PO.Export;
import com.example.entities.Query.QueryExport;
import com.example.service.EventService;
import com.example.service.ExportService;
import com.example.service.impl.EventServiceImpl;
import com.example.service.impl.ExportServiceImpl;
import com.example.utils.Action;
import com.example.utils.ResultInfo;
import com.example.utils.SnowIdUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

/**
 * @author youngoo
 * @date 2021/12/27 14:36
 */
@WebServlet(name = "exportServlet", urlPatterns = "/export/*")
public class ExportServlet extends BaseServlet{

    @Action("查看专家列表")
    public ResultInfo getExportList(HttpServletRequest request, HttpServletResponse response) {
        // 处理请求参数
        String name = request.getParameter("name");
        String speciality = request.getParameter("speciality");
        String organization = request.getParameter("organization");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        QueryExport queryExport = new QueryExport(name, speciality, organization, page == null ? null : (Integer.parseInt(page) - 1) * Integer.parseInt(limit), limit == null ? null : Integer.parseInt(limit));
        ExportService exportService = new ExportServiceImpl();
        return exportService.queryAll(queryExport);
    }

    @Action("添加专家信息")
    public ResultInfo addExport(HttpServletRequest request, HttpServletResponse response) {
        // 处理参数
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String pictureUrl = request.getParameter("pictureUrl");
        String birthday = request.getParameter("birthday");
        String speciality = request.getParameter("speciality");
        String job = request.getParameter("job");
        String organization = request.getParameter("organization");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String location = request.getParameter("location");
        long id = SnowIdUtils.uniqueLong();
        Export export = new Export(id, name, Integer.parseInt(sex), pictureUrl, LocalDate.parse(birthday), speciality, job, organization, email, phone, location);
        ExportService exportService = new ExportServiceImpl();
        return exportService.addExport(export);
    }

    @Action("修改专家信息")
    public ResultInfo updateExport(HttpServletRequest request, HttpServletResponse response) {

        // 处理参数
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String pictureUrl = request.getParameter("pictureUrl");
        String birthday = request.getParameter("birthday");
        String speciality = request.getParameter("speciality");
        String job = request.getParameter("job");
        String organization = request.getParameter("organization");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String location = request.getParameter("location");
        Export export = new Export(Long.parseLong(id), name, Integer.parseInt(sex), pictureUrl, LocalDate.parse(birthday), speciality, job, organization, email, phone, location);
        ExportService exportService = new ExportServiceImpl();
        return exportService.updateExport(export);
    }

    @Action("删除专家信息")
    public ResultInfo deleteExport(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        long id = Long.parseLong(idStr);
        ExportService exportService = new ExportServiceImpl();
        return exportService.delExport(id);
    }

    @Action("查看会商记录列表")
    public ResultInfo getGoverningList(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        EventService eventService = new EventServiceImpl();
        return eventService.getGoverningList((Integer.parseInt(page) - 1) * Integer.parseInt(limit), Integer.parseInt(limit));
    }
}
