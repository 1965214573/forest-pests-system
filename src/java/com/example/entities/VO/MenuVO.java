package com.example.entities.VO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author youngoo
 * @date 2021/12/9 20:27
 */
@Builder
@Data
public class MenuVO {
    private Integer menuId;
    private String menuName;
    private String menuUrl;
    private String icon;
    private List<MenuVO> childrenMenu;
}
