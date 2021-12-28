package com.example.entities.PO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author youngoo
 * @date 2021/12/28 21:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordDetail {

    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long recordId;
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long drugOrDeviceId;
    private Integer outletNumber;
}
