package com.example.entities.Query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author youngoo
 * @date 2021/12/29 10:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryUser {
    private Integer roleId;
    private Integer page;
    private Integer limit;
}
