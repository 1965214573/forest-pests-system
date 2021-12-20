package com.example.service.impl;

import com.example.entities.PO.Menu;
import com.example.entities.PO.User;
import com.example.entities.VO.MenuVO;
import com.example.mapper.CommonMapper;
import com.example.service.CommonService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author youngoo
 * @date 2021/12/9 20:42
 */
public class CommonServiceImpl implements CommonService {
    /**
     * 根据角色id获取menu列表
     * 嵌套查询再进行封装整个内容
     *
     * @param roleId 角色id
     * @return 直接返回一个具有树状结构的数组
     */
    @Override
    public ResultInfo showMenuList(Integer roleId) {

        try (SqlSession session = MybatisUtil.getSession()) {
            CommonMapper commonMapper = session.getMapper(CommonMapper.class);
            // 查询的根菜单
            List<Menu> rootMenuList = commonMapper.getRootMenuList(roleId);
            // 将要返回的数据
            List<MenuVO> menuVOList = new ArrayList<>(rootMenuList.size());
            for (Menu menu : rootMenuList) {
                // 查询子菜单
                List<Menu> childrenMenuList = commonMapper.getMenuListBypId(menu.getMenuId());
                // 封装的子菜单
                List<MenuVO> childrenMenuVOList = null;

                // 转换子菜单PO -> VO
                if (childrenMenuList != null) {
                    for (Menu childrenMenu : childrenMenuList) {
                        if (childrenMenuVOList == null) {
                            childrenMenuVOList = new ArrayList<>(childrenMenuList.size());
                        }
                        childrenMenuVOList.add(
                                MenuVO.builder()
                                        .menuId(childrenMenu.getMenuId())
                                        .menuName(childrenMenu.getMenuName())
                                        .menuUrl(childrenMenu.getMenuUrl())
                                        .icon(childrenMenu.getIcon())
                                        .build());
                    }
                }

                // 转换最终的菜单
                menuVOList.add(
                        MenuVO.builder()
                                .menuId(menu.getMenuId())
                                .menuName(menu.getMenuName())
                                .menuUrl(menu.getMenuUrl())
                                .icon(menu.getIcon())
                                .childrenMenu(childrenMenuVOList)
                                .build()
                );
            }
            HashMap<String, Object> menuResult = new HashMap<>();
            menuResult.put("menuList", menuVOList);
            return ResultInfo.builder()
                    .code(200)
                    .msg("导航菜单")
                    .data(menuResult)
                    .build();
        }
    }

    @Override
    public ResultInfo showMenuList(User user) {
        try(SqlSession session = MybatisUtil.getSession()) {
            CommonMapper mapper = session.getMapper(CommonMapper.class);
            List<MenuVO> menuVOList = mapper.getMenuList(user);
            HashMap<String, Object> menuResult = new HashMap<>(1);
            menuResult.put("menuList", menuVOList);
            return ResultInfo.builder()
                    .code(200)
                    .msg("导航菜单")
                    .data(menuResult)
                    .build();
        }
    }
}
