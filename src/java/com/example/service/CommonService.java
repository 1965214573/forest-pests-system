package com.example.service;

import com.example.entities.PO.User;
import com.example.entities.VO.MenuVO;
import com.example.utils.ResultInfo;

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
    ResultInfo showMenuList(Integer roleId);

    /**
     * 根据用户获取menu列表
     * 嵌套查询再进行封装整个内容
     * @param user 角色id
     * @return 直接返回一个具有树状结构的数组
     */
    ResultInfo showMenuList(User user);
}
