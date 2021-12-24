package com.example.service;

import com.example.entities.PO.Disease;
import com.example.entities.PO.Mouse;
import com.example.entities.Query.QueryDisease;
import com.example.entities.Query.QueryMouse;
import com.example.utils.ResultInfo;

/**
 * @author youngoo
 */
public interface MouseService {
    /**
     * 条件查询所有鼠害信息
     * @param queryMouse 查询条件对象
     * @return 统一返回的数据格式
     */
    ResultInfo queryList(QueryMouse queryMouse);

    /**
     * 添加病害信息
     * @param mouse 鼠害对象
     * @return 统一返回数据格式
     */
    ResultInfo addMouse(Mouse mouse);

    /**
     * 根据id删除鼠害信息
     * @param id 鼠害id
     * @return 统一返回数据格式
     */
    ResultInfo delMouse(long id);
}
