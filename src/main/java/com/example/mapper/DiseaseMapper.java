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

    /**
     * 添加一条数据
     * @param disease 要添加的病害对象
     * @return 受影响的行数
     */
    int insertOne(Disease disease);

    /**
     * 根据id删除一条记录
     * @param id 病害id
     * @return 受影响的行数
     */
    int delById(long id);
}
