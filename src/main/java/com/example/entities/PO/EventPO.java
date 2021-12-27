package com.example.entities.PO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author youngoo
 * @date 2021/12/26 19:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventPO {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    @JSONField(ordinal = 1)
    private String name;
    @JSONField(ordinal = 2,format = "yyyy-MM-dd")
    private LocalDate createDate;
    @JSONField(ordinal = 3)
    private Integer disasterStage;
    @JSONField(ordinal = 4)
    private String disasterDescribe;
    @JSONField(ordinal = 5)
    private String damage;
    @JSONField(ordinal = 6)
    private String exportAdvice;
    @JSONField(ordinal = 7)
    private String measure;
    @JSONField(ordinal = 8)
    private String pictureUrl;
    @JSONField(ordinal = 9)
    private Integer disasterType;
    @JSONField(ordinal = 10)
    private Integer discoveryType;
    @JSONField(ordinal = 11, serializeUsing = ToStringSerializer.class)
    private Long areaId;
    @JSONField(ordinal = 12, serializeUsing = ToStringSerializer.class)
    private Long smallClassId;
    @JSONField(ordinal = 13)
    private String influenceArea;
    private Integer status;
}
