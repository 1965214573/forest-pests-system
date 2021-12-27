package com.example.mapper;

import com.example.entities.PO.Export;
import com.example.entities.Query.QueryExport;

import java.util.List;

/**
 * @author youngoo
 */
public interface ExportMapper {
    /**
     * 条件查询所有专家信息
     * @param queryExport 查询条件
     * @return 专家列表
     */
    List<Export> selectAll(QueryExport queryExport);

    /**
     * 根据条件统计所有专家数量
     * @param queryExport 查询条件
     * @return 专家数量
     */
    int countAll(QueryExport queryExport);

    /**
     * 插入一条专家信息
     * @param export 专家对象
     * @return 受影响的行数
     */
    int insertOne(Export export);

    /**
     * 修改一条专家信息
     * @param export 专家对象
     * @return 受影响的行数
     */
    int updateExport(Export export);

    /**
     * 根据id删除专家信息
     * @param id 专家id
     * @return 受影响的行数
     */
    int deleteById(long id);
}
