package com.example.entities.PO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author youngoo
 * @date 2021/12/27 14:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Export {

    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    private String name;
    private Integer sex;
    private String pictureUrl;
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate birthday;
    private String speciality;
    private String job;
    private String organization;
    private String email;
    private String phone;
    private String location;
}
