package com.example.service.impl;

import com.example.entities.PO.DeviceDrug;
import com.example.entities.PO.Record;
import com.example.entities.PO.RecordDetail;
import com.example.entities.Query.QueryDeviceDrug;
import com.example.entities.Query.QueryOut;
import com.example.entities.VO.RecordDetailVO;
import com.example.entities.VO.RecordVO;
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

    /**
     * 添加出库信息到数据库
     *
     * @param record  出库记录
     * @param details 对应记录详情
     * @return 统一返回对象
     */
    @Override
    public ResultInfo addOutletDetail(Record record, List<RecordDetail> details) {
        try (SqlSession session = MybatisUtil.getSession()) {
            StoreMapper storeMapper = session.getMapper(StoreMapper.class);
            if (storeMapper.addRecord(record) != 0) {
                if (storeMapper.batchSaveRecordDetail(details) != 0) {
                    session.commit();
                    return ResultInfo.ok();
                }
            }
        } catch (Exception e) {
            logger.error("数据库操作异常", e);
        }
        return ResultInfo.err();
    }

    /**
     * 条件查询出库信息
     *
     * @param queryOut 查询条件
     * @return 统一返回对象
     */
    @Override
    public ResultInfo queryOut(QueryOut queryOut) {
        try (SqlSession session = MybatisUtil.getSession()) {
            StoreMapper storeMapper = session.getMapper(StoreMapper.class);
            int count = storeMapper.countOut(queryOut);
            Map<String, Object> data = new HashMap<>(2);
            data.put("count", count);
            if (count != 0) {
                List<RecordVO> recordList = storeMapper.selectOutList(queryOut);
                data.put("deviceDrugOutList", recordList);
            }
            return ResultInfo.builder()
                    .code(200)
                    .msg("出库信息")
                    .data(data)
                    .build();
        } catch (Exception e) {
            logger.error("数据库操作异常", e);
        }
        return ResultInfo.err();
    }

    /**
     * 查询出库记录的详情
     *
     * @param recordId 出库记录id
     * @return 统一返回对象
     */
    @Override
    public ResultInfo queryOutDetail(long recordId) {
        try (SqlSession session = MybatisUtil.getSession()) {
            StoreMapper storeMapper = session.getMapper(StoreMapper.class);
            List<RecordDetailVO> recordDetails = storeMapper.selectOutDetailByRecordId(recordId);
            Map<String, Object> data = new HashMap<>(1);
            data.put("recordDetail", recordDetails);
            return ResultInfo.builder()
                    .code(200)
                    .msg("出库详情")
                    .data(data)
                    .build();
        } catch (Exception e) {
            logger.error("数据库操作异常", e);
        }
        return ResultInfo.err();
    }
}
