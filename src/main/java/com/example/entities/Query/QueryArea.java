package com.example.entities.Query;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author youngoo
 * @date 2021/12/24 16:39
 */
@Data
@AllArgsConstructor
public class QueryArea {
    private String name;
    private String forestType;
    private Long classId;
    private Integer page;
    private Integer limit;
}
