package com.example.entities.PO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author youngoo
 * @date 2021/12/23 21:54
 */
@Data
@AllArgsConstructor
public class Mouse {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    @JSONField(ordinal = 1)
    private String name;
    @JSONField(ordinal = 2)
    private String food;
    @JSONField(ordinal = 3)
    private String breed;
    @JSONField(ordinal = 4)
    private String pictureUrl;
    @JSONField(ordinal = 5)
    private String enemy;
    @JSONField(ordinal = 6)
    private String damage;
    @JSONField(ordinal = 7)
    private String measure;


}
