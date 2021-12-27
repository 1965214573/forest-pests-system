package com.example.service.impl;

import com.alibaba.druid.support.opds.udf.SqlCodeStat;
import com.example.entities.PO.Export;
import com.example.entities.Query.QueryExport;
import com.example.mapper.ExportMapper;
import com.example.service.ExportService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author youngoo
 * @date 2021/12/27 14:42
 */
public class ExportServiceImpl implements ExportService {
    private final Logger logger = Logger.getLogger(this.getClass());
    /**
     * 查询所有专家信息
     *
     * @param queryExport 查询条件
     * @return 统一返回对象
     */
    @Override
    public ResultInfo queryAll(QueryExport queryExport) {
        try (SqlSession session = MybatisUtil.getSession()) {
            ExportMapper exportMapper = session.getMapper(ExportMapper.class);
            int count = exportMapper.countAll(queryExport);
            Map<String, Object> data = new HashMap<>(2);
            data.put("count", count);
            if (count != 0) {
                List<Export> exportList = exportMapper.selectAll(queryExport);
                data.put("exportList", exportList);
            }
            return ResultInfo.builder()
                    .code(200)
                    .msg("专家信息")
                    .data(data)
                    .build();
        } catch (Exception e) {
            logger.error("数据库操作失败", e);
        }
        return ResultInfo.err();
    }

    /**
     * 添加一条专家信息
     *
     * @param export 专家对象
     * @return 统一返回对象
     */
    @Override
    public ResultInfo addExport(Export export) {
        try (SqlSession session = MybatisUtil.getSession()) {
            ExportMapper exportMapper = session.getMapper(ExportMapper.class);
            if (exportMapper.insertOne(export) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            logger.error("数据库操作失败", e);
        }
        return ResultInfo.err();
    }

    /**
     * 修改一条专家信息
     *
     * @param export 专家啊对象
     * @return 统一返回对象
     */
    @Override
    public ResultInfo updateExport(Export export) {
        try (SqlSession session = MybatisUtil.getSession()) {
            ExportMapper exportMapper = session.getMapper(ExportMapper.class);
            if (exportMapper.updateExport(export) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            logger.error("数据库操作失败", e);
        }
        return ResultInfo.err();
    }

    /**
     * 根据id删除一条专家记录
     *
     * @param id 专家id
     * @return 统一返回对象
     */
    @Override
    public ResultInfo delExport(long id) {
        try (SqlSession session = MybatisUtil.getSession()) {
            ExportMapper exportMapper = session.getMapper(ExportMapper.class);
            if (exportMapper.deleteById(id) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            logger.error("数据库操作失败", e);
        }
        return ResultInfo.err();
    }
}
