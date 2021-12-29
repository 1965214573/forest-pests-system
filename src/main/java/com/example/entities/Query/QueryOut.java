package com.example.entities.Query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 出库信息查询条件
 * @author youngoo
 * @date 2021/12/29 8:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryOut {

    private LocalDate startDate;
    private LocalDate endDate;
    private Long classId;
    private Integer page;
    private Integer limit;
}
