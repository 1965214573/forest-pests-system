package com.example.mapper;

import com.example.entities.PO.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author youngoo
 */
public interface CommonMapper {

    /**
     * 根据角色id查询所有根菜单
     * @param roleId 角色id
     * @return 查询到的根结果列表
     */
    List<Menu> getRootMenuList(Integer roleId);

    /**
     * 根据父级菜单id查询所有的菜单
     * @param pId 父级菜单id
     * @return 查询到的结果
     */
    List<Menu> getMenuListBypId(Integer pId);
}
