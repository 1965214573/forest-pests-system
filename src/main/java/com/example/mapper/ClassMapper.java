package com.example.mapper;

import com.example.entities.PO.Clazz;
import com.example.entities.Query.QueryClass;
import com.example.entities.VO.ClassVO;

import java.util.List;

/**
 * @author youngoo
 */
public interface ClassMapper {
    /**
     * 添加一条小班记录
     * @param clazz 小班对象
     * @return 受影响的行数
     */
    int insertOne(Clazz clazz);

    /**
     * 条件查询所有小班信息
     * @param queryClass 查询条件
     * @return 小班信息列表
     */
    List<ClassVO> queryAll(QueryClass queryClass);

    /**
     * 条件统计小班数量
     * @param queryClass 查询条件
     * @return 小班数量
     */
    int countClass(QueryClass queryClass);
}
