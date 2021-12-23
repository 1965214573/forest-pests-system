package com.example.entities.Query;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author youngoo
 * @date 2021/12/22 18:26
 */
@Data
@AllArgsConstructor
public class QueryDisease {
    private String name;
    private String symptom;
    private Integer page;
    private Integer limit;
}
