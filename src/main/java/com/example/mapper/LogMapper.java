package com.example.mapper;

import com.example.entities.PO.Log;

/**
 * @author youngoo
 */
public interface LogMapper {
    /**
     * 添加日志记录到数据库
     * @param log 日志对象
     * @return 受影响的行数
     */
    int insertLog(Log log);
}
