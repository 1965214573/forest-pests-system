package com.example.entities.VO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author youngoo
 * @date 2021/12/24 17:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreaVO {
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
    @JSONField(ordinal = 5)
    private String className;
}
