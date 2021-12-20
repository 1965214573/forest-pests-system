package com.example.mapper;

import com.example.entities.PO.Pest;
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
}
