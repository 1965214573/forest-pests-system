package com.example.entities.VO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author youngoo
 * @date 2021/12/26 20:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventSimpleVO {

    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    @JSONField(ordinal = 1)
    private String name;
    @JSONField(ordinal = 2,format = "yyyy-MM-dd")
    private LocalDate createDate;
    @JSONField(ordinal = 3)
    private Integer disasterStage;
    @JSONField(ordinal = 4)
    private String measure;
    @JSONField(ordinal = 5)
    private String areaName;
    private Integer status;
}
