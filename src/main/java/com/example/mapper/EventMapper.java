package com.example.mapper;

import com.example.entities.PO.EventPO;
import com.example.entities.PO.GoverningDetail;
import com.example.entities.Query.QueryEvent;
import com.example.entities.VO.EventSimpleVO;
import com.example.entities.VO.EventVO;
import org.apache.ibatis.annotations.Param;

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
    List<EventSimpleVO> selectSimpleList(QueryEvent queryEvent);

    /**
     * 统计所有事件数量
     * @param queryEvent 查询条件
     * @return 事件数量
     */
    int countEvent(QueryEvent queryEvent);

    /**
     * 根据id查询事件记录详情
     * @param eventId 事件id
     * @return 事件对象
     */
    EventVO queryById(long eventId);

    /**
     * 更新一条事件记录
     * @param event 事件对象
     * @return 受影响的行数
     */
    int updateEvent(EventPO event);

    /**
     * 获取所有需要会商的事件
     * @param page 分页参数
     * @param limit 分页参数
     * @return 事件列表
     */
    List<EventVO> queryGoverningList(@Param("page") int page, @Param("limit") int limit);

    /**
     * 统计会商事件数量
     * @return 数量
     */
    int countGoverning();

    /**
     * 更改事件的会商状态
     * @param eventId 事件id
     * @return 受影响的行数
     */
    int governingEvent(long eventId);

    /**
     * 添加事件对应会商记录
     * @param governingDetail 会商记录对象
     * @return 受影响行数
     */
    int insertGoverningResult(GoverningDetail governingDetail);

    /**
     * 根据事件id查询会商结果记录
     * @param eventId 事件id
     * @return 记录列表
     */
    List<GoverningDetail> queryGoverningDetailByEventId(long eventId);
}
