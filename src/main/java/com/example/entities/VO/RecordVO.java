package com.example.entities.VO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author youngoo
 * @date 2021/12/29 9:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordVO {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate createDate;
    private String className;
    private String exerciser;
}
