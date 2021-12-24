package com.example.entities.PO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author youngoo
 * @date 2021/12/24 19:17
 */
@Data
@AllArgsConstructor
public class Clazz {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    private String name;
    private String principal;
    private String phone;
    private Integer peopleCount;
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate createDate;
}
