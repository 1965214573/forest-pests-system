package com.example.service;

import com.example.entities.PO.EventPO;
import com.example.entities.PO.GoverningDetail;
import com.example.entities.Query.QueryEvent;
import com.example.utils.ResultInfo;

/**
 * @author youngoo
 */
public interface EventService {
    /**
     * 添加一条事件记录
     * @param event 事件对象
     * @return 统一返回对象
     */
    ResultInfo addEvent(EventPO event);

    /**
     * 查询事件简单信息列表
     * @param queryEvent 查询条件
     * @return 统一返回对象
     */
    ResultInfo querySimpleList(QueryEvent queryEvent);

    /**
     * 根据id查询事件记录
     * @param eventId 事件id
     * @return 统一返回对象
     */
    ResultInfo getEventById(long eventId);

    /**
     * 更新事件记录
     * @param event 事件对象
     * @return 统一返回对象
     */
    ResultInfo updateEvent(EventPO event);

    /**
     * 获取需要会商的事件记录
     * @param page 起始索引
     * @param limit 每页条数
     * @return 统一返回对象
     */
    ResultInfo getGoverningList(int page, int limit);

    /**
     * 将事件设置为会商状态
     * @param eventId 事件id
     * @return 统一返回对象
     */
    ResultInfo governingEvent(long eventId);

    /**
     * 添加事件的会商结果
     * @param governingDetail 会商结果对象
     * @return 统一返回对象
     */
    ResultInfo addGoverningResult(GoverningDetail governingDetail);

    /**
     * 查询事件的会商记录
     * @param eventId 事件id
     * @return 统一返回对象
     */
    ResultInfo getGoverningListByEventId(long eventId);
}
