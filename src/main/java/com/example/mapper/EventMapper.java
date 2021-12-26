package com.example.mapper;

import com.example.entities.PO.EventPO;
import com.example.entities.Query.QueryEvent;
import com.example.entities.VO.EventVO;

import java.util.List;

/**
 * @author youngoo
 */
public interface EventMapper {
    /**
     * 插入一条事件记录
     * @param event 事件对象
     * @return 受影响的行数
     */
    int insertOne(EventPO event);

    /**
     * 查询所有事件信息
     * @param queryEvent 查询条件对象
     * @return 事件信息列表
     */
    List<EventVO> selectSimpleList(QueryEvent queryEvent);

    /**
     * 统计所有事件数量
     * @param queryEvent 查询条件
     * @return 事件数量
     */
    int countEvent(QueryEvent queryEvent);
}
