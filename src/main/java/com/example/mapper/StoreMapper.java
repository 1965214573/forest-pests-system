package com.example.mapper;

import com.example.entities.PO.DeviceDrug;
import com.example.entities.PO.Record;
import com.example.entities.PO.RecordDetail;
import com.example.entities.Query.QueryDeviceDrug;
import com.example.entities.Query.QueryOut;
import com.example.entities.VO.RecordDetailVO;
import com.example.entities.VO.RecordVO;
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

    /**
     * 条件查询所有的出库信息
     * @param queryOut 查询条件
     * @return 出库信息列表
     */
    List<RecordVO> selectOutList(QueryOut queryOut);

    /**
     * 条件统计出库信息数量
     * @param queryOut 查询条件
     * @return 数量
     */
    int countOut(QueryOut queryOut);

    /**
     * 根据出库记录id查询出库记录详情
     * @param recordId 出库记录id
     * @return 出库详情列表
     */
    List<RecordDetailVO> selectOutDetailByRecordId(long recordId);
}
