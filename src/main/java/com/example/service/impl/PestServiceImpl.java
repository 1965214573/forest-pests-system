package com.example.service.impl;

import com.example.entities.PO.Pest;
import com.example.entities.Query.QueryPest;
import com.example.mapper.PestMapper;
import com.example.service.PestService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author youngoo
 * @date 2021/12/22 19:06
 */
public class PestServiceImpl implements PestService {

    private final Logger logger = Logger.getLogger(this.getClass());
    /**
     * 根据条件，查询所有的害虫列表
     *
     * @param queryPest 插叙条件
     * @return 封装好的返回对象
     */
    @Override
    public ResultInfo queryList(QueryPest queryPest) {
        try(SqlSession session = MybatisUtil.getSession()) {
            PestMapper pestMapper = session.getMapper(PestMapper.class);
            int count = pestMapper.countAll(queryPest);
            Map<String, Object> data = new HashMap<>(2);
            data.put("count", count);
            if (count != 0) {
                data.put("pestList", pestMapper.queryAll(queryPest));
            }
            return ResultInfo.builder()
                    .code(200)
                    .msg("操作成功")
                    .data(data)
                    .build();
        } catch (Exception e) {

            logger.debug("数据操作异常！");
            return ResultInfo.err();
        }
    }

    /**
     * 添加虫害信息
     *
     * @param pest 虫害对象
     * @return 返回对象
     */
    @Override
    public ResultInfo addPest(Pest pest) {
        try (SqlSession session = MybatisUtil.getSession()) {
            PestMapper pestMapper = session.getMapper(PestMapper.class);
            int row = pestMapper.insertPest(pest);
            if (row != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("操作失败");
        }
        return ResultInfo.err();
    }

    /**
     * 根据id删除虫害信息
     *
     * @param id 虫害id
     * @return 返回响应对象
     */
    @Override
    public ResultInfo delPestById(long id) {
        try (SqlSession session = MybatisUtil.getSession()) {
            PestMapper pestMapper = session.getMapper(PestMapper.class);
            if (pestMapper.deletePest(id) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("数据库操作异常");
        }
        return ResultInfo.err();
    }
}
