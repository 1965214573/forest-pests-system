package com.example.entities.PO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author youngoo
 * @date 2021/12/29 16:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    private String detail;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime executeDate;
}
