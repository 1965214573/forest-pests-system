package com.example.service;

import com.example.entities.PO.Pest;
import com.example.entities.Query.QueryPest;
import com.example.utils.ResultInfo;

/**
 * @author youngoo
 */
public interface PestService {

    /**
     * 根据条件，查询所有的害虫列表
     * @param queryPest 插叙条件
     * @return 封装好的返回对象
     */
    ResultInfo queryList(QueryPest queryPest);

    /**
     * 添加虫害信息
     * @param pest 虫害对象
     * @return 返回对象
     */
    ResultInfo addPest(Pest pest);

    /**
     * 根据id删除虫害信息
     * @param id 虫害id
     * @return 返回响应对象
     */
    ResultInfo delPestById(long id);
}
