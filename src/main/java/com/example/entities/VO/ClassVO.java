package com.example.entities.VO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author youngoo
 * @date 2021/12/24 20:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassVO {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    private String name;
    private String principal;
    private String phone;
    private Integer peopleCount;
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate createDate;
    private AreaVO area;
}
