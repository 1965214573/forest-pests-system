package com.example.service;

import com.example.entities.PO.DeviceDrug;
import com.example.entities.Query.QueryDeviceDrug;
import com.example.utils.ResultInfo;

/**
 * @author youngoo
 */
public interface StoreService {
    /**
     * 条件查询所有药剂器械信息
     * @param queryDeviceDrug 查询条件
     * @return 统一返回对象
     */
    ResultInfo queryAllDeviceDrug(QueryDeviceDrug queryDeviceDrug);

    /**
     * 添加药品器械信息
     * @param deviceDrug 药品器械对象
     * @return 统一返回对象
     */
    ResultInfo addDeviceDrug(DeviceDrug deviceDrug);
}
