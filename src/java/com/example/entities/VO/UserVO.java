package com.example.entities.VO;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author youngoo
 * @date 2021/12/9 19:05
 */
@Data
@Builder
public class UserVO {

    private Integer userId;
    private String userName;
    private String userPwd;
    private String level;
    private String realName;
}
