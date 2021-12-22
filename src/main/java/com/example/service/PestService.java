package com.example.service;

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
}
