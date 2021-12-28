package com.example.servlet;

import com.example.entities.PO.DeviceDrug;
import com.example.entities.Query.QueryDeviceDrug;
import com.example.service.StoreService;
import com.example.service.impl.StoreServiceImpl;
import com.example.utils.ResultInfo;
import com.example.utils.SnowIdUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author youngoo
 * @date 2021/12/28 15:00
 */
@WebServlet(name = "storeServlet", urlPatterns = "/store/*")
public class StoreServlet extends BaseServlet{

    public ResultInfo getDeviceDrugList(HttpServletRequest request, HttpServletResponse response) {
        // 处理参数
        String name = request.getParameter("name");
        String treatType = request.getParameter("treatType");
        String type = request.getParameter("type");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        QueryDeviceDrug queryDeviceDrug = new QueryDeviceDrug(
                name,
                treatType == null ? null : Integer.parseInt(treatType),
                type == null ? null : Integer.parseInt(type),
                page == null? null : ((Integer.parseInt(page) - 1) * Integer.parseInt(limit)),
                limit == null? null : Integer.parseInt(limit)
        );
        StoreService storeService = new StoreServiceImpl();
        return storeService.queryAllDeviceDrug(queryDeviceDrug);

    }

    public ResultInfo addDeviceDrug(HttpServletRequest request, HttpServletResponse response) {
        // 处理参数
        String name = request.getParameter("name");
        String treatType = request.getParameter("treatType");
        String type = request.getParameter("type");
        String usage = request.getParameter("usage");
        long id = SnowIdUtils.uniqueLong();
        DeviceDrug deviceDrug = new DeviceDrug(
                id,
                name,
                treatType == null ? null : Integer.parseInt(treatType),
                type == null ? null : Integer.parseInt(type),
                usage
        );
        StoreService storeService = new StoreServiceImpl();
        return storeService.addDeviceDrug(deviceDrug);
    }
}
