package com.example.mapper;

import com.example.entities.PO.Role;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 添加用户角色对应信息
     * @param userId 用户id
     * @param roleId 角色id
     * @return 受影响的行数
     */
    int insertUser(@Param("userId") int userId, @Param("roleId") int roleId);

    /**
     * 修改用户对应的角色信息
     * @param userId 用户id
     * @param roleId 角色id
     * @return 受影响的行数
     */
    int updateUserRole(@Param("userId") Integer userId, @Param("roleId") int roleId);
}
