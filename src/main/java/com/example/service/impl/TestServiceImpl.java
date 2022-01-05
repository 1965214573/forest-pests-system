package com.example.service.impl;

import com.example.entities.PO.Log;
import com.example.mapper.LogMapper;
import com.example.service.TestService;
import com.example.utils.MybatisUtil;
import com.example.utils.SnowIdUtils;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDateTime;

/**
 * @author youngoo
 * @date 2022/1/5 21:13
 */
public class TestServiceImpl implements TestService {
    /**
     * 修改日志信息
     */
    @Override
    public void updateLog() {
        SqlSession sqlSession = MybatisUtil.getSession();
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
        Log log = new Log(SnowIdUtils.uniqueLong(), "测试语句1", LocalDateTime.now());
        logMapper.insertLog(log);
        int a = 1/0;
        Log log2 = new Log(SnowIdUtils.uniqueLong(), "测试语句2", LocalDateTime.now());
        logMapper.insertLog(log2);
    }
}
