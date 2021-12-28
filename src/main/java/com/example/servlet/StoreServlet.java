package com.example.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entities.PO.DeviceDrug;
import com.example.entities.PO.Record;
import com.example.entities.PO.RecordDetail;
import com.example.entities.Query.QueryDeviceDrug;
import com.example.service.StoreService;
import com.example.service.impl.StoreServiceImpl;
import com.example.utils.ResultInfo;
import com.example.utils.SnowIdUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public ResultInfo addOutInfo(HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        JSONArray list = new JSONArray();
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            json= JSONObject.parseObject(sb.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }
        long id = SnowIdUtils.uniqueLong();

        Record record = new Record(id, LocalDate.now(), json.getLong("classId"), json.getString("exerciser"));

        JSONArray jsonArray = json.getJSONArray("detail");
        List<RecordDetail> details = new ArrayList<>(jsonArray.size());

        for (Object next : jsonArray) {
            JSONObject jsonObject = (JSONObject) next;
            details.add(new RecordDetail(SnowIdUtils.uniqueLong(), id, jsonObject.getLong("id"), jsonObject.getInteger("count")));
        }
        StoreService storeService = new StoreServiceImpl();
        return storeService.addOutletDetail(record, details);
    }
}
