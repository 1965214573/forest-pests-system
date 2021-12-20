package com.example.service;

import com.example.utils.ResultInfo;

/**
 * @author youngoo
 */
public interface DocumentService {

    /**
     * 分页查询虫害信息
     * @param page 当前页
     * @param limit 每页条数
     * @return 封装好的结果
     */
    ResultInfo getPestListList(String page, String limit);
}
