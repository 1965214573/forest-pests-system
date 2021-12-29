package com.example.entities.Query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author youngoo
 * @date 2021/12/29 17:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryLog {
    private String startDate;
    private String endDate;
    private Integer page;
    private Integer limit;
}
