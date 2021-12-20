package com.example.mapper;

import com.example.entities.PO.Role;

import java.util.List;

/**
 * @author youngoo
 */
public interface RoleMapper {
    /**
     * 查询所有的角色信息
     * @return 返回查询到的结果
     */
    List<Role> selectAll();
}
