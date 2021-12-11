package com.example.mapper;

import com.example.entities.PO.User;
import com.example.entities.VO.UserVO;

/**
 * @author youngoo
 */
public interface UserMapper {
    /**
     * 根据用户的用户名，密码来查询信息
     * @param user 查询条件
     * @return 查询结果
     */
    UserVO queryByNameAndPwd(User user);
}
