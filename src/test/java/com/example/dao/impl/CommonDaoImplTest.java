package com.example.dao.impl;

import com.example.entities.PO.Menu;
import com.example.entities.PO.User;
import com.example.entities.VO.MenuVO;
import com.example.mapper.CommonMapper;
import com.example.mapper.TestDemoMapper;
import com.example.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CommonDaoImplTest {


    @Test
    public void testMenuList() {
        try (SqlSession session = MybatisUtil.getSession()) {
            CommonMapper mapper = session.getMapper(CommonMapper.class);

            List<MenuVO> menuList = mapper.getMenuList(User.builder().userId(1).build());
            menuList.forEach(System.out::println);
        }
    }

    @Test
    public void testMenuIf() {
        try (SqlSession session = MybatisUtil.getSession()) {
            TestDemoMapper mapper = session.getMapper(TestDemoMapper.class);
            List<Menu> menus = mapper.testIf(Menu.builder().menuName("首页").build());
            menus.forEach(System.out::println);
        }
    }
}