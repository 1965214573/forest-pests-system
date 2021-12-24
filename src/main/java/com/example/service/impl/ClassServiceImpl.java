package com.example.service.impl;

import com.example.entities.PO.Clazz;
import com.example.entities.Query.QueryClass;
import com.example.entities.VO.ClassVO;
import com.example.mapper.AreaMapper;
import com.example.mapper.ClassMapper;
import com.example.service.ClassService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author youngoo
 * @date 2021/12/24 19:38
 */
public class ClassServiceImpl implements ClassService {
    private final Logger logger = Logger.getLogger(this.getClass());
    /**
     * 添加一条小班记录，并将对应的区域信息中，添加该小班记录的id
     *
     * @param clazz  小班信息
     * @param areaId 绑定对应的区域信息
     * @return 统一返回结果
     */
    @Override
    public ResultInfo addClass(Clazz clazz, long areaId) {
        try (SqlSession session = MybatisUtil.getSession()) {
            // 添加小班信息，并对区域进行绑定
            ClassMapper classMapper = session.getMapper(ClassMapper.class);
            if (classMapper.insertOne(clazz) != 0) {
                AreaMapper areaMapper = session.getMapper(AreaMapper.class);
                if (areaMapper.BindClass(areaId, clazz.getId()) != 0) {
                    session.commit();
                    return ResultInfo.ok();
                }
            }
        } catch (Exception e) {
            logger.debug("数据库操作失败");
        }
        return ResultInfo.err();
    }

    /**
     * 条件查询所有的小班信息
     *
     * @param queryClass 查询条件
     * @return 统一结果对象
     */
    @Override
    public ResultInfo queryList(QueryClass queryClass) {
        try (SqlSession session = MybatisUtil.getSession()) {

            ClassMapper classMapper = session.getMapper(ClassMapper.class);
            int count = classMapper.countClass(queryClass);
            Map<String, Object> data = new HashMap<>(2);
            data.put("count", count);
            if (count != 0) {
                List<ClassVO> classList = classMapper.queryAll(queryClass);
                data.put("classList", classList);
            }
            return ResultInfo.builder()
                    .code(200)
                    .msg("小班信息")
                    .data(data)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("数据库操作失败");
        }
        return ResultInfo.err();
    }
}
