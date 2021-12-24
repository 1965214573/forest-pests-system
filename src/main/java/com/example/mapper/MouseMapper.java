package com.example.mapper;

import com.example.entities.PO.Mouse;
import com.example.entities.Query.QueryMouse;

import java.util.List;

/**
 * @author youngoo
 */
public interface MouseMapper {
    /**
     * 条件查询鼠害数量
     * @param queryMouse 查询条件
     * @return 数量信息
     */
    int countAll(QueryMouse queryMouse);

    /**
     * 插入一条鼠害信息
     * @param mouse 鼠害对象
     * @return 受影响的行数
     */
    int insertOne(Mouse mouse);

    /**
     * 根据鼠害id删除一条鼠害记录
     * @param id 鼠害id
     * @return 受影响的行数
     */
    int delById(long id);

    /**
     * 条件查询所有鼠害信息
     * @param queryMouse 查询条件对象
     * @return 返回鼠害列表
     */
    List<Mouse> queryAll(QueryMouse queryMouse);
}
