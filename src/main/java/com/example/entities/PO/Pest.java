package com.example.entities.PO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author youngoo
 * @date 2021/12/13 16:46
 */
@Data
@AllArgsConstructor
public class Pest {
    @JSONField(serializeUsing= ToStringSerializer.class)
    private Long id;
    private String pestName;
    private String hostName;
    private String breed;
    private String enemy;
    private String damage;
    private String measures;
    private String childPicture;
    private String adultPicture;
}
