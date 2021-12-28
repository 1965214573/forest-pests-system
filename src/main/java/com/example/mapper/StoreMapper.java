package com.example.mapper;

import com.example.entities.PO.DeviceDrug;
import com.example.entities.Query.QueryDeviceDrug;

import java.util.List;

/**
 * @author youngoo
 */
public interface StoreMapper {
    /**
     * 条件统计所有药剂器械数量
     * @param queryDeviceDrug 查询条件对象
     * @return 统计的数量
     */
    int countDeviceDrug(QueryDeviceDrug queryDeviceDrug);

    /**
     * 条件查询所有的药剂器械信息
     * @param queryDeviceDrug 查询条件对象
     * @return 药剂器械列表
     */
    List<DeviceDrug> selectDeviceDrug(QueryDeviceDrug queryDeviceDrug);

    /**
     * 插入一条药品器械信息到数据库
     * @param deviceDrug 药品器械信息
     * @return 受影响的行数
     */
    int insertDeviceDrug(DeviceDrug deviceDrug);
}
