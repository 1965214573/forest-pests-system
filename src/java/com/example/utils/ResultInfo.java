package com.example.utils;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * @author youngoo
 * @date 2021/12/11 16:25
 */
@Builder
@Data
public class ResultInfo{
    private Integer code;
    private String msg;
    private Map<String, Object> data;

    /**
     * 快速返回正确响应但无数据的内容
     * @return 返回一个结果对象
     */
    public static ResultInfo ok() {
        return builder().code(ResultCode.SUCCESS)
                .msg("成功")
                .build();
    }

    /**
     * 快速返回错误响应但无数据的内容
     * @return 返回一个结果对象
     */
    public static ResultInfo err() {
        return builder().code(ResultCode.ERROR)
                .msg("失败")
                .build();
    }
}
