package com.example.service.impl;

import com.example.entities.PO.Disease;
import com.example.entities.Query.QueryDisease;
import com.example.mapper.DiseaseMapper;
import com.example.mapper.PestMapper;
import com.example.service.DiseaseService;
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
public class DiseaseServiceImpl implements DiseaseService {

    private final Logger logger = Logger.getLogger(this.getClass());
    /**
     * 条件查询所有病害信息
     *
     * @param queryDisease 查询条件对象
     * @return 统一返回的数据格式
     */
    @Override
    public ResultInfo queryList(QueryDisease queryDisease) {
        try(SqlSession session = MybatisUtil.getSession()) {
            DiseaseMapper diseaseMapper = session.getMapper(DiseaseMapper.class);
            int count = diseaseMapper.countAll(queryDisease);
            Map<String, Object> data = new HashMap<>(2);
            data.put("count", count);
            if (count != 0) {
                data.put("diseaseList", diseaseMapper.queryAll(queryDisease));
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
     * 添加病害信息
     * @param disease 病害对象
     * @return 统一结果对象
     */
    @Override
    public ResultInfo addDisease(Disease disease) {

        try (SqlSession session = MybatisUtil.getSession()) {
            DiseaseMapper diseaseMapper = session.getMapper(DiseaseMapper.class);
            if (diseaseMapper.insertOne(disease) != 0) {
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
     * 根据id删除病害信息
     *
     * @param id 病害id
     * @return 统一返回数据格式
     */
    @Override
    public ResultInfo delDisease(long id) {
        try (SqlSession session = MybatisUtil.getSession()) {
            DiseaseMapper diseaseMapper = session.getMapper(DiseaseMapper.class);
            if (diseaseMapper.delById(id) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            logger.debug("数据库操作失败");
        }
        return ResultInfo.err();
    }
}
