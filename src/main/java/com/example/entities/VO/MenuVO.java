package com.example.entities.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author youngoo
 * @date 2021/12/9 20:27
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuVO {
    private Integer menuId;
    private String menuName;
    private String menuUrl;
    private String icon;
    private List<MenuVO> childrenMenu;
}
