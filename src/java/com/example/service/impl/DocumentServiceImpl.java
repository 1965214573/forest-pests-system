package com.example.service.impl;

import com.example.entities.PO.Pest;
import com.example.mapper.PestMapper;
import com.example.service.DocumentService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author youngoo
 * @date 2021/12/13 16:41
 */
public class DocumentServiceImpl implements DocumentService {
    /**
     * 分页查询虫害信息
     *
     * @param page  当前页
     * @param limit 每页条数
     * @return 封装好的结果
     */
    @Override
    public ResultInfo getPestListList(String page, String limit) {
        try(SqlSession session = MybatisUtil.getSession()) {
            // 查询总记录数
            PestMapper mapper = session.getMapper(PestMapper.class);
            int count = mapper.countPest();
            int p = 1;
            int s = 10;
            if (page != null) {
                p = Integer.parseInt(page);
                s = Integer.parseInt(limit);
            }
            List<Pest> pestList = mapper.selectPest((p - 1) * s, s);
            Map<String, Object> pestListMap = null;
            if (pestList != null) {
                pestListMap = new HashMap<>(2);
                pestListMap.put("count", count);
                pestListMap.put("pestList", pestList);
            }
            return ResultInfo.builder()
                    .code(200)
                    .msg("虫害数据")
                    .data(pestListMap)
                    .build();
        }
    }
}
