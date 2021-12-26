package com.example.entities.Query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author youngoo
 * @date 2021/12/26 19:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryEvent {
    private String name;
    private Integer disasterStage;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer page;
    private Integer limit;
}
