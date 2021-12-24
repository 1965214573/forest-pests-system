package com.example.service.impl;

import com.example.entities.PO.Disease;
import com.example.entities.PO.Mouse;
import com.example.entities.Query.QueryDisease;
import com.example.entities.Query.QueryMouse;
import com.example.mapper.DiseaseMapper;
import com.example.mapper.MouseMapper;
import com.example.service.DiseaseService;
import com.example.service.MouseService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author youngoo
 * @date 2021/12/23 21:46
 */
public class MouseServiceImpl implements MouseService {

    private final Logger logger = Logger.getLogger(this.getClass());
    /**
     * 条件查询所有鼠害信息
     *
     * @param queryMouse 查询条件对象
     * @return 统一返回的数据格式
     */
    @Override
    public ResultInfo queryList(QueryMouse queryMouse) {
        try(SqlSession session = MybatisUtil.getSession()) {
            MouseMapper mouseMapper = session.getMapper(MouseMapper.class);
            int count = mouseMapper.countAll(queryMouse);
            Map<String, Object> data = new HashMap<>(2);
            data.put("count", count);
            if (count != 0) {
                data.put("mouseList", mouseMapper.queryAll(queryMouse));
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
     * 添加鼠害信息
     * @param mouse 鼠害对象
     * @return 统一结果对象
     */
    @Override
    public ResultInfo addMouse(Mouse mouse) {

        try (SqlSession session = MybatisUtil.getSession()) {
            MouseMapper mouseMapper = session.getMapper(MouseMapper.class);
            if (mouseMapper.insertOne(mouse) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("数据操作异常！");
        }
        return ResultInfo.err();
    }

    /**
     * 根据id删除鼠害信息
     *
     * @param id 鼠害id
     * @return 统一返回数据格式
     */
    @Override
    public ResultInfo delMouse(long id) {
        try (SqlSession session = MybatisUtil.getSession()) {
            MouseMapper mouseMapper = session.getMapper(MouseMapper.class);
            if (mouseMapper.delById(id) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            logger.debug("数据库操作失败");
        }
        return ResultInfo.err();
    }
}
