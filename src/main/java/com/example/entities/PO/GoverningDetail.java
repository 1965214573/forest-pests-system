package com.example.entities.PO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author youngoo
 * @date 2021/12/28 11:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoverningDetail {

    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long eventId;
    private String exportList;
    private String result;
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate createDate;
}
