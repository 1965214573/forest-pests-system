package com.example.service.impl;

import com.example.entities.PO.DeviceDrug;
import com.example.entities.Query.QueryDeviceDrug;
import com.example.mapper.StoreMapper;
import com.example.service.StoreService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author youngoo
 * @date 2021/12/28 15:12
 */
public class StoreServiceImpl implements StoreService {
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * 条件查询所有药剂器械信息
     *
     * @param queryDeviceDrug 查询条件
     * @return 统一返回参数
     */
    @Override
    public ResultInfo queryAllDeviceDrug(QueryDeviceDrug queryDeviceDrug) {
        try (SqlSession session = MybatisUtil.getSession()) {
            StoreMapper storeMapper = session.getMapper(StoreMapper.class);
            int count = storeMapper.countDeviceDrug(queryDeviceDrug);
            Map<String, Object> data = new HashMap<>(2);
            data.put("count", count);
            if (count != 0) {
                List<DeviceDrug> deviceDrugList = storeMapper.selectDeviceDrug(queryDeviceDrug);
                data.put("deviceDrugList", deviceDrugList);
            }
            return ResultInfo.builder()
                    .code(200)
                    .msg("药剂器械信息")
                    .data(data)
                    .build();
        } catch (Exception e) {
            logger.error("数据操作异常", e);
        }
        return ResultInfo.err();
    }

    /**
     * 添加药品器械信息
     *
     * @param deviceDrug 药品器械对象
     * @return 统一返回对象
     */
    @Override
    public ResultInfo addDeviceDrug(DeviceDrug deviceDrug) {
        try (SqlSession session = MybatisUtil.getSession()) {
            StoreMapper storeMapper = session.getMapper(StoreMapper.class);
            if (storeMapper.insertDeviceDrug(deviceDrug) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            logger.error("数据库操作异常", e);
        }
        return ResultInfo.err();
    }
}
