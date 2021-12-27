package com.example.entities.Query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author youngoo
 * @date 2021/12/27 14:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryExport {
    private String name;
    private String speciality;
    private String organization;
    private Integer page;
    private Integer limit;
}
