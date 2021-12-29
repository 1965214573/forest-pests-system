package com.example.entities.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author youngoo
 * @date 2021/12/29 9:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordDetailVO {
    private String name;
    private Integer type;
    private Integer treatType;
    private Integer outletNumber;
}
