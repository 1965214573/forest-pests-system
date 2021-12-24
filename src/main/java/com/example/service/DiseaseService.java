package com.example.service;

import com.example.entities.PO.Disease;
import com.example.entities.Query.QueryDisease;
import com.example.utils.ResultInfo;

/**
 * @author youngoo
 */
public interface DiseaseService {
    /**
     * 条件查询所有病害信息
     * @param queryDisease 查询条件对象
     * @return 统一返回的数据格式
     */
    ResultInfo queryList(QueryDisease queryDisease);

    /**
     * 添加病害信息
     * @param disease 病害对象
     * @return 统一返回数据格式
     */
    ResultInfo addDisease(Disease disease);

    /**
     * 根据id删除病害信息
     * @param id 病害id
     * @return 统一返回数据格式
     */
    ResultInfo delDisease(long id);
}
