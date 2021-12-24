package com.example.entities.PO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author youngoo
 */
@Data
@AllArgsConstructor
public class Area {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    @JSONField(ordinal = 1)
    private String name;
    @JSONField(ordinal = 2)
    private String forestType;
    @JSONField(ordinal = 3)
    private String landType;
    @JSONField(ordinal = 4)
    private String dominantTree;
}