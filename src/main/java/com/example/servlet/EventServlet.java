package com.example.servlet;

import com.example.entities.PO.EventPO;
import com.example.entities.Query.QueryEvent;
import com.example.entities.VO.EventVO;
import com.example.service.EventService;
import com.example.service.impl.EventServiceImpl;
import com.example.utils.ResultInfo;
import com.example.utils.SnowIdUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.spec.ECField;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;

/**
 * @author youngoo
 * @date 2021/12/26 18:53
 */
@WebServlet(name = "eventServlet", urlPatterns = "/event/*")
public class EventServlet extends BaseServlet{

    public ResultInfo addEvent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String createDate = request.getParameter("createDate");
        String disasterStage = request.getParameter("disasterStage");
        String disasterDescribe = request.getParameter("disasterDescribe");
        String damage = request.getParameter("damage");
        String measure = request.getParameter("measure");
        String pictureUrl = request.getParameter("pictureUrl");
        String disasterType = request.getParameter("disasterType");
        String discoveryType = request.getParameter("discoveryType");
        String areaId = request.getParameter("areaId");
        String influenceArea = request.getParameter("influenceArea");

        long id = SnowIdUtils.uniqueLong();
        EventPO event = new EventPO(
                id,
                name,
                LocalDate.parse(createDate),
                Integer.parseInt(disasterStage),
                disasterDescribe,
                damage,
                null,
                measure,
                pictureUrl,
                Integer.parseInt(disasterType),
                Integer.parseInt(discoveryType),
                Long.parseLong(areaId),
                null,
                influenceArea,
                null
        );

        EventService eventService = new EventServiceImpl();
        return eventService.addEvent(event);
    }

    public ResultInfo getEventList(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String disasterStage = request.getParameter("disasterStage");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        QueryEvent queryEvent = new QueryEvent(
                name,
                (disasterStage == null || "".equals(disasterStage)) ? null : Integer.parseInt(disasterStage),
                (startDate == null || "".equals(startDate)) ? null : LocalDate.parse(startDate),
                (endDate == null || "".equals(endDate)) ? null : LocalDate.parse(endDate),
                (Integer.parseInt(page) - 1) * Integer.parseInt(limit),
                Integer.parseInt(limit)
        );

        EventService eventService = new EventServiceImpl();
        return eventService.querySimpleList(queryEvent);
    }

    public ResultInfo getEventById(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        EventService eventService = new EventServiceImpl();
        return eventService.getEventById(Long.parseLong(id));
    }

    public ResultInfo updateEvent(HttpServletRequest request, HttpServletResponse response) {
        // 处理参数
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String createDate = request.getParameter("createDate");
        String disasterStage = request.getParameter("disasterStage");
        String disasterDescribe = request.getParameter("disasterDescribe");
        String damage = request.getParameter("damage");
        String exportAdvice = request.getParameter("exportAdvice");
        String measure = request.getParameter("measure");
        String pictureUrl = request.getParameter("pictureUrl");
        String disasterType = request.getParameter("disasterType");
        String discoveryType = request.getParameter("discoveryType");
        String areaId = request.getParameter("areaId");
        String influenceArea = request.getParameter("influenceArea");

        EventPO eventPO = new EventPO(Long.parseLong(id),
                name,
                LocalDate.parse(createDate),
                Integer.parseInt(disasterStage),
                disasterDescribe,
                damage,
                exportAdvice,
                measure,
                pictureUrl,
                Integer.parseInt(disasterType),
                Integer.parseInt(discoveryType),
                Long.parseLong(areaId),
                null,
                influenceArea,
                null
        );
        EventService eventService = new EventServiceImpl();
        return eventService.updateEvent(eventPO);
    }

    public ResultInfo governingEvent(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        EventService eventService = new EventServiceImpl();
        return eventService.governingEvent(Long.parseLong(idStr));
    }
}
