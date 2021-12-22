package com.example.service.impl;

import com.example.entities.Query.QueryPest;
import com.example.mapper.PestMapper;
import com.example.service.PestService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author youngoo
 * @date 2021/12/22 19:06
 */
public class PestServiceImpl implements PestService {
    /**
     * 根据条件，查询所有的害虫列表
     *
     * @param queryPest 插叙条件
     * @return 封装好的返回对象
     */
    @Override
    public ResultInfo queryList(QueryPest queryPest) {
        try(SqlSession session = MybatisUtil.getSession()) {
            PestMapper pestMapper = session.getMapper(PestMapper.class);
            int count = pestMapper.countAll(queryPest);
            Map<String, Object> data = new HashMap<>(2);
            data.put("count", count);
            if (count != 0) {
                data.put("pestList", pestMapper.queryAll(queryPest));
            }
            return ResultInfo.builder()
                    .code(200)
                    .msg("操作成功")
                    .data(data)
                    .build();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(this.getClass());
            logger.debug("数据操作异常！");
            return ResultInfo.err();
        }
    }
}
