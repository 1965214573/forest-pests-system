package com.example.service.impl;

import com.alibaba.druid.support.opds.udf.SqlCodeStat;
import com.example.entities.PO.Area;
import com.example.entities.PO.LandType;
import com.example.entities.Query.QueryArea;
import com.example.entities.VO.AreaVO;
import com.example.mapper.AreaMapper;
import com.example.service.AreaService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author youngoo
 * @date 2021/12/24 15:30
 */
public class AreaServiceImpl implements AreaService {
    private final Logger logger = Logger.getLogger(this.getClass());
    /**
     * 查询所有地类
     *
     * @return 统一查询结果
     */
    @Override
    public ResultInfo queryLandTypeList() {
        try (SqlSession session = MybatisUtil.getSession()) {
             AreaMapper areaMapper = session.getMapper(AreaMapper.class);
             List<LandType> landTypeList = areaMapper.queryLandType();
             if (landTypeList != null && !landTypeList.isEmpty()) {
                 Map<String, Object> data = new HashMap<>(1);
                 data.put("landTypeList", landTypeList);
                 return ResultInfo.builder()
                         .code(200)
                         .msg("查询成功")
                         .data(data)
                         .build();
             }
        } catch (Exception e) {
            logger.debug("数据操作异常");
        }
        return ResultInfo.err();
    }

    /**
     * 添加一条区域信息
     *
     * @param area 区域对象
     * @return 统一查询结果
     */
    @Override
    public ResultInfo addArea(Area area) {
        try (SqlSession session = MybatisUtil.getSession()) {
            AreaMapper areaMapper = session.getMapper(AreaMapper.class);
            if (areaMapper.insertOne(area) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            logger.debug("数据库操作失败");
        }
        return ResultInfo.err();
    }

    /**
     * 条件查询所有区域信息
     *
     * @param queryArea 条件对象
     * @return 统一查询结果
     */
    @Override
    public ResultInfo queryAreaList(QueryArea queryArea) {
        try (SqlSession session = MybatisUtil.getSession()) {
            AreaMapper areaMapper = session.getMapper(AreaMapper.class);
            int count = areaMapper.countAll(queryArea);
            Map<String, Object> data = new HashMap<>(2);
            data.put("count", count);
            if (count != 0) {
                List<AreaVO> areaList = areaMapper.queryAll(queryArea);
                data.put("areaList", areaList);
            }
            return ResultInfo.builder()
                    .code(200)
                    .msg("区域数据")
                    .data(data)
                    .build();

        } catch (Exception e) {
            logger.debug("数据库操作失败");
        }
        return ResultInfo.err();
    }

    /**
     * 查询未绑定小班的区域
     *
     * @return 统一查询结果
     */
    @Override
    public ResultInfo queryNoClassArea() {
        try (SqlSession session = MybatisUtil.getSession()) {
            AreaMapper areaMapper = session.getMapper(AreaMapper.class);
            List<Area> areaList = areaMapper.queryNoClassArea();
            Map<String, Object> data = new HashMap<>(1);
            data.put("areaList", areaList);
            return ResultInfo.builder()
                    .code(200)
                    .msg("未绑定区域数据")
                    .data(data)
                    .build();

        } catch (Exception e) {
            logger.debug("数据库操作失败");
        }
        return ResultInfo.err();
    }

    /**
     * 查询所有区域
     *
     * @return 统一返回结果
     */
    @Override
    public ResultInfo querySimpleArea() {
        try (SqlSession session = MybatisUtil.getSession()) {
            AreaMapper areaMapper = session.getMapper(AreaMapper.class);
            List<Area> areaList = areaMapper.querySimpleAll();
            Map<String, Object> data = new HashMap<>(1);
            data.put("areaList", areaList);
            return ResultInfo.builder()
                    .code(200)
                    .msg("区域列表")
                    .data(data)
                    .build();
        } catch (Exception e) {
            logger.error("数据库操作异常", e);
        }
        return ResultInfo.err();
    }
}
