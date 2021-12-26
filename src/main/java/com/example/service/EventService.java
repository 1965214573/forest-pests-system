package com.example.service;

import com.example.entities.PO.EventPO;
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
}
