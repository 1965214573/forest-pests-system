package com.example.mapper;

import com.example.entities.PO.Area;
import com.example.entities.PO.LandType;
import com.example.entities.Query.QueryArea;
import com.example.entities.VO.AreaVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author youngoo
 * @date 2021/12/24 15:37
 */
public interface AreaMapper {
    /**
     * 查询地类信息
     * @return 地类列表
     */
    List<LandType> queryLandType();

    /**
     * 添加一条区域信息到数据库
     * @param area 区域对象
     * @return 受影响的行数
     */
    int insertOne(Area area);

    /**
     * 条件查询所有区域信息
     * @param queryArea 条件对象
     * @return 区域列表
     */
    List<AreaVO> queryAll(QueryArea queryArea);

    /**
     * 条件统计区域数量
     * @param queryArea 条件对象
     * @return 总计
     */
    int countAll(QueryArea queryArea);

    /**
     * 查询未绑定的区域信息
     * @return 区域集合
     */
    List<Area> queryNoClassArea();

    /**
     * 将区域信息与小班信息进行绑定
     * @param areaId 区域id
     * @param classId 小班id
     * @return 受影响的行数
     */
    int bindClass(@Param("areaId") long areaId, @Param("classId") long classId);

    /**
     * 解绑指定的班级信息
     * @param clazzId 小班id
     * @return 受影响的行数
     */
    int unBindClass(Long clazzId);

    /**
     * 查询所有区域信息
     * @return 区域列表
     */
    List<AreaVO> querySimpleAll();
}
