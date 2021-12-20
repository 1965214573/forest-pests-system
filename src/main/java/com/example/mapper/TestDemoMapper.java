package com.example.mapper;

import com.example.entities.PO.Menu;

import java.util.List;

/**
 * @author youngoo
 */
public interface TestDemoMapper {

    /**
     * 测试方法
     *
     * @param menu 菜单
     * @return 查询到的结果
     */
    List<Menu> testIf(Menu menu);
}
