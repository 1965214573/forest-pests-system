package com.example.entities.Query;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author youngoo
 * @date 2021/12/24 19:54
 */
@Data
@AllArgsConstructor
public class QueryClass {
    private String className;
    private Long areaId;
    private Integer page;
    private Integer limit;
}
