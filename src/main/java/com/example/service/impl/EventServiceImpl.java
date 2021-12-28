package com.example.service.impl;

import com.example.entities.PO.EventPO;
import com.example.entities.PO.GoverningDetail;
import com.example.entities.Query.QueryEvent;
import com.example.entities.VO.EventSimpleVO;
import com.example.entities.VO.EventVO;
import com.example.mapper.EventMapper;
import com.example.service.EventService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import com.mysql.cj.callback.MysqlCallbackHandler;
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
                List<EventSimpleVO> eventVOList = eventMapper.selectSimpleList(queryEvent);
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

    /**
     * 根据id查询事件记录
     *
     * @param eventId 事件id
     * @return 统一返回对象
     */
    @Override
    public ResultInfo getEventById(long eventId) {
        try (SqlSession session = MybatisUtil.getSession()) {
            EventMapper eventMapper = session.getMapper(EventMapper.class);
            EventVO eventVO = eventMapper.queryById(eventId);
            Map<String, Object> data = new HashMap<>(1);
            data.put("eventInfo", eventVO);
            return ResultInfo.builder()
                    .code(200)
                    .msg("事件记录详情")
                    .data(data)
                    .build();
        } catch (Exception e) {
            logger.error("数据库操作失败", e);
        }
        return ResultInfo.err();
    }

    /**
     * 更新事件记录
     *
     * @param event 事件对象
     * @return 统一返回对象
     */
    @Override
    public ResultInfo updateEvent(EventPO event) {
        try (SqlSession session = MybatisUtil.getSession()) {
            EventMapper eventMapper = session.getMapper(EventMapper.class);
            if (eventMapper.updateEvent(event) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            logger.error("数据库操作异常", e);
        }
        return ResultInfo.err();
    }

    /**
     * 获取需要会商的事件记录
     *
     * @param page  起始索引
     * @param limit 每页条数
     * @return 统一返回对象
     */
    @Override
    public ResultInfo getGoverningList(int page, int limit) {
        try (SqlSession session = MybatisUtil.getSession()) {
            EventMapper eventMapper = session.getMapper(EventMapper.class);
            int count = eventMapper.countGoverning();
            Map<String, Object> data = new HashMap<>(2);
            data.put("count", count);
            if (count != 0) {
                List<EventVO> eventVOList = eventMapper.queryGoverningList(page, limit);
                data.put("eventList", eventVOList);
            }
            return ResultInfo.builder()
                    .code(200)
                    .msg("会商事件列表")
                    .data(data)
                    .build();
        } catch (Exception e) {
            logger.error("数据库操作异常", e);
        }
        return ResultInfo.err();
    }

    /**
     * 将事件设置为会商状态
     *
     * @param eventId 事件id
     * @return 统一返回对象
     */
    @Override
    public ResultInfo governingEvent(long eventId) {
        try (SqlSession session = MybatisUtil.getSession()) {
            EventMapper eventMapper = session.getMapper(EventMapper.class);
            if (eventMapper.governingEvent(eventId) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            logger.error("数据库操作异常", e);
        }
        return ResultInfo.err();
    }

    /**
     * 添加事件的会商结果
     *
     * @param governingDetail 会商结果对象
     * @return 统一返回对象
     */
    @Override
    public ResultInfo addGoverningResult(GoverningDetail governingDetail) {
        try (SqlSession session = MybatisUtil.getSession()) {
            EventMapper eventMapper = session.getMapper(EventMapper.class);
            if (eventMapper.insertGoverningResult(governingDetail) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            logger.error("数据库操作异常", e);
        }
        return ResultInfo.err();
    }

    /**
     * 查询事件的会商记录
     *
     * @param eventId 事件id
     * @return 统一返回对象
     */
    @Override
    public ResultInfo getGoverningListByEventId(long eventId) {
        try (SqlSession session = MybatisUtil.getSession()) {
            EventMapper eventMapper = session.getMapper(EventMapper.class);
            Map<String, Object> data = new HashMap<>(1);

            List<GoverningDetail> governingDetails = eventMapper.queryGoverningDetailByEventId(eventId);
                data.put("governingList", governingDetails);

            return ResultInfo.builder()
                    .code(200)
                    .msg("事件会商结果列表")
                    .data(data)
                    .build();
        } catch (Exception e) {
            logger.error("数据库操作异常", e);
        }
        return ResultInfo.err();
    }
}
