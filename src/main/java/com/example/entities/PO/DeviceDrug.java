package com.example.entities.PO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author youngoo
 * @date 2021/12/28 15:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDrug {

    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    private String name;
    private Integer treatType;
    private Integer type;
    private String usage;
}
