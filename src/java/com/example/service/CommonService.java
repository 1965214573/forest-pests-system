package com.example.service;

import com.example.entities.VO.MenuVO;

import java.util.List;

/**
 * @author youngoo
 */
public interface CommonService {

    /**
     * 根据角色id获取menu列表
     * 嵌套查询再进行封装整个内容
     * @param roleId 角色id
     * @return 直接返回一个具有树状结构的数组
     */
    List<MenuVO> showMenuList(Integer roleId);
}