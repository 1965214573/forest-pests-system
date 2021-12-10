package com.example.entities.VO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author youngoo
 * @date 2021/12/9 20:27
 */
@Builder
public class MenuVO {
    private Integer menuId;
    private String menuName;
    private String menuUrl;
    private String icon;
    private List<MenuVO> childrenMenu;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<MenuVO> getChildrenMenu() {
        return childrenMenu;
    }

    public void setChildrenMenu(List<MenuVO> childrenMenu) {
        this.childrenMenu = childrenMenu;
    }

    @Override
    public String toString() {
        return "MenuVO{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", icon='" + icon + '\'' +
                ", childrenMenu=" + childrenMenu +
                '}';
    }
}
