package com.example.service.impl;

import com.example.entities.PO.EventPO;
import com.example.entities.Query.QueryEvent;
import com.example.entities.VO.EventVO;
import com.example.mapper.EventMapper;
import com.example.service.EventService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author youngoo
 * @date 2021/12/26 19:15
 */
public class EventServiceImpl implements EventService {

    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * 添加一条事件记录
     *
     * @param event 事件对象
     * @return 统一返回对象
     */
    @Override
    public ResultInfo addEvent(EventPO event) {
        try (SqlSession session = MybatisUtil.getSession()) {
            EventMapper eventMapper = session.getMapper(EventMapper.class);
            if (eventMapper.insertOne(event) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            logger.error("数据库操作异常", e);
        }
        return ResultInfo.err();
    }

    /**
     * 查询事件简单信息列表
     *
     * @param queryEvent 查询条件
     * @return 统一返回对象
     */
    @Override
    public ResultInfo querySimpleList(QueryEvent queryEvent) {
        try(SqlSession session = MybatisUtil.getSession()) {
            EventMapper eventMapper = session.getMapper(EventMapper.class);
            int row = eventMapper.countEvent(queryEvent);
            Map<String, Object> data = new HashMap<>(2);
            data.put("count", row);
            if (row != 0) {
                List<EventVO> eventVOList = eventMapper.selectSimpleList(queryEvent);
                data.put("eventList", eventVOList);
            }
            return ResultInfo.builder()
                    .code(200)
                    .msg("事件记录列表")
                    .data(data)
                    .build();

        }catch (Exception e) {
            logger.error("数据库操作失败", e);
        }
        return ResultInfo.err();
    }
}
