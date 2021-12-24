package com.example.service;

import com.example.entities.PO.Area;
import com.example.entities.Query.QueryArea;
import com.example.utils.ResultInfo;

/**
 * @author youngoo
 */
public interface AreaService {
    /**
     * 查询所有地类
     * @return 统一查询结果
     */
    ResultInfo queryLandTypeList();

    /**
     * 添加一条区域信息
     * @param area 区域对象
     * @return 统一查询结果
     */
    ResultInfo addArea(Area area);

    /**
     * 条件查询所有区域信息
     * @param queryArea 条件对象
     * @return 统一查询结果
     */
    ResultInfo queryAreaList(QueryArea queryArea);

    /**
     * 查询未绑定小班的区域
     * @return 统一查询结果
     */
    ResultInfo queryNoClassArea();
}
