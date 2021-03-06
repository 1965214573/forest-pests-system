package com.example.servlet;

import com.example.entities.PO.Clazz;
import com.example.entities.Query.QueryClass;
import com.example.service.ClassService;
import com.example.service.impl.ClassServiceImpl;
import com.example.utils.Action;
import com.example.utils.ResultInfo;
import com.example.utils.SnowIdUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

/**
 * @author youngoo
 * @date 2021/12/24 18:47
 */
@WebServlet(name = "classServlet", urlPatterns = "/class/*")
public class ClassServlet extends BaseServlet{

    @Action("添加小班")
    public ResultInfo addClass(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String principal = request.getParameter("principal");
        String phone = request.getParameter("phone");
        String peopleCount = request.getParameter("peopleCount");
        String areaIdStr = request.getParameter("areaId");
        long id = SnowIdUtils.uniqueLong();
        Clazz clazz = new Clazz(id, name, principal, phone, Integer.parseInt(peopleCount), LocalDate.now());
        long areaId = Long.parseLong(areaIdStr);
        ClassService classService = new ClassServiceImpl();
        return classService.addClass(clazz, areaId);
    }

    @Action("查看小班")
    public ResultInfo getClassList(HttpServletRequest request, HttpServletResponse response) {
        String className = request.getParameter("className");
        String areaId = request.getParameter("areaId");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        QueryClass queryClass = new QueryClass(className, areaId == null || areaId.equals("") ? null : Long.parseLong(areaId), (Integer.parseInt(page) - 1) * Integer.parseInt(limit), Integer.parseInt(limit));
        ClassService classService = new ClassServiceImpl();
        return classService.queryList(queryClass);
    }

    @Action("查看小班")
    public ResultInfo getClass(HttpServletRequest request, HttpServletResponse response) {
        ClassService classService = new ClassServiceImpl();
        return classService.querySimpleList();
    }

    @Action("修改小班")
    public ResultInfo updateClass(HttpServletRequest request, HttpServletResponse response) {
        // 处理参数
        String id = request.getParameter("id");
        String className = request.getParameter("className");
        String principal = request.getParameter("principal");
        String phone = request.getParameter("phone");
        String peopleCount = request.getParameter("peopleCount");
        String areaId = request.getParameter("areaId");

        Clazz clazz = new Clazz(Long.parseLong(id), className, principal, phone, Integer.parseInt(peopleCount), null);
        ClassService classService = new ClassServiceImpl();
        return classService.updateClass(clazz, Long.parseLong(areaId));
    }
}
