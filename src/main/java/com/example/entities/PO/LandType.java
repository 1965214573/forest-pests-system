package com.example.entities.PO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author youngoo
 * @date 2021/12/24 15:33
 */
@Data
@AllArgsConstructor
public class LandType {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    private String landType;
}
