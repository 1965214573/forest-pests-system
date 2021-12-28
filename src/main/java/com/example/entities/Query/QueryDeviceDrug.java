package com.example.entities.Query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author youngoo
 * @date 2021/12/28 15:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryDeviceDrug {
    private String name;
    private Integer treatType;
    private Integer type;
    private Integer page;
    private Integer limit;
}
