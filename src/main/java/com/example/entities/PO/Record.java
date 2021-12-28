package com.example.entities.PO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author youngoo
 * @date 2021/12/28 21:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate createDate;
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long smallClassId;
    private String exerciser;
}
