package com.example.service;

import com.example.entities.PO.Clazz;
import com.example.entities.Query.QueryClass;
import com.example.utils.ResultInfo;

/**
 * @author youngoo
 */
public interface ClassService {
    /**
     * 添加一条小班记录，并将对应的区域信息中，添加该小班记录的id
     * @param clazz 小班信息
     * @param areaId 绑定对应的区域信息
     * @return 统一返回结果
     */
    ResultInfo addClass(Clazz clazz, long areaId);

    /**
     * 条件查询所有的小班信息
     * @param queryClass 查询条件
     * @return 统一结果对象
     */
    ResultInfo queryList(QueryClass queryClass);

    /**
     * 直接获取小班简单信息
     * @return 统一结果对象
     */
    ResultInfo querySimpleList();

    /**
     * 更新小班信息，先修改小班信息，再对对应的区域信息修改为当前小班
     * @param clazz 小班信息对象
     * @param areaId 区域id
     * @return 统一返回对象
     */
    ResultInfo updateClass(Clazz clazz, long areaId);
}
