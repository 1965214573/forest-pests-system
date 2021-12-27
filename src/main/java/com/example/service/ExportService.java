package com.example.service;

import com.example.entities.PO.Export;
import com.example.entities.Query.QueryExport;
import com.example.utils.ResultInfo;

/**
 * @author youngoo
 */
public interface ExportService {
    /**
     * 查询所有专家信息
     * @param queryExport 查询条件
     * @return 统一返回对象
     */
    ResultInfo queryAll(QueryExport queryExport);

    /**
     * 添加一条专家信息
     * @param export 专家对象
     * @return 统一返回对象
     */
    ResultInfo addExport(Export export);

    /**
     * 修改一条专家信息
     * @param export 专家啊对象
     * @return 统一返回对象
     */
    ResultInfo updateExport(Export export);

    /**
     * 根据id删除一条专家记录
     * @param id 专家id
     * @return 统一返回对象
     */
    ResultInfo delExport(long id);
}
