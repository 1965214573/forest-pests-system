package com.example.mapper;

import com.example.entities.PO.Disease;
import com.example.entities.Query.QueryDisease;

import java.util.List;

/**
 * @author youngoo
 */
public interface DiseaseMapper {
    /**
     * 条件统计所有病害数量
     * @param queryDisease 条件查询
     * @return 总数
     */
    int countAll(QueryDisease queryDisease);

    /**
     * 条件查询所有病害
     * @param queryDisease 查询条件
     * @return 病害列表
     */
    List<Disease> queryAll(QueryDisease queryDisease);
}
