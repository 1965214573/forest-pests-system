package com.example.mapper;

import com.example.entities.PO.Pest;
import com.example.entities.Query.QueryPest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author youngoo
 */
public interface PestMapper {
    /**
     * 查询数据条数
     * @return 查询到的结果
     */
    int countPest();

    /**
     * 分页查询所有虫害数据
     * @param page 当前页
     * @param size 分页大小
     * @return 结果
     */
    List<Pest> selectPest(@Param("page") int page, @Param("size") int size);

    /**
     * 条件统计数量
     * @param queryPest 查询条件
     * @return 数量
     */
    int countAll(QueryPest queryPest);

    /**
     * 条件查询所有的虫害信息
     * @param queryPest 查询条件
     * @return 查询到的结合
     */
    List<Pest> queryAll(QueryPest queryPest);

    /**
     * 向数据库添加一条虫害记录
     * @param pest 虫害信息
     * @return 受影响的行数
     */
    int insertPest(Pest pest);

    /**
     * 删除一条虫害记录
     * @param id 虫害id
     * @return 受影响的行数
     */
    int deletePest(long id);
}
