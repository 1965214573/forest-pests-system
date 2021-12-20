package com.example.entities.PO;

import lombok.*;

/**
 * 用户表对应的bean
 *
 * @author youngoo
 * @date 2021/12/9 18:40
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Integer userId;
    private String userName;
    private String userPwd;
    private String realName;
    private Integer isDeleted;
}
