package com.example.mapper;

import com.example.entities.PO.DeviceDrug;
import com.example.entities.PO.Record;
import com.example.entities.PO.RecordDetail;
import com.example.entities.Query.QueryDeviceDrug;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 添加一条出库管理简单记录
     * @param record 记录对象
     * @return 受影响的行数
     */
    int addRecord(Record record);

    /**
     * 批量插入出库记录详细信息
     * @param details 出库记录列表
     * @return 受影响的行数
     */
    int batchSaveRecordDetail(@Param("details") List<RecordDetail> details);
}
