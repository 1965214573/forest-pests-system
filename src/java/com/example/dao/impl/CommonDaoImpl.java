package com.example.dao.impl;

import com.example.dao.CommonDao;
import com.example.entities.PO.Menu;
import com.example.jdbc.QueryRunner;
import com.example.jdbc.handler.BeanListHandler;

import java.util.List;

/**
 * @author youngoo
 * @date 2021/12/9 20:45
 */
public class CommonDaoImpl implements CommonDao {

    QueryRunner queryRunner = new QueryRunner();

    /**
     * 根据角色id查询所有根菜单
     *
     * @param roleId 角色id
     * @return 查询到的根结果列表
     */
    @Override
    public List<Menu> getRootMenuList(Integer roleId) {
        String sql = "select menus.* from role_menu inner join menus on role_menu.menuId = menus.menuId where role_menu.roleId = ? and menus.pId = 0";
        return queryRunner.query(sql, new BeanListHandler<>(Menu.class), roleId);
    }

    /**
     * 根据父级菜单id查询所有的菜单
     *
     * @param pId 父级菜单id
     * @return 查询到的结果
     */
    @Override
    public List<Menu> getMenuListBypId(Integer pId) {
        String sql = "SELECT * FROM menus WHERE pId = ?";
        return queryRunner.query(sql, new BeanListHandler<>(Menu.class), pId);
    }
}
