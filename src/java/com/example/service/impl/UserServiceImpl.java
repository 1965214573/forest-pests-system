package com.example.service.impl;

import com.example.entities.PO.User;
import com.example.entities.VO.UserVO;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;

import java.util.HashMap;

/**
 * @author youngoo
 * @date 2021/12/11 17:34
 */
public class UserServiceImpl implements UserService {
    /**
     * 数据库密码没有进行加密的登录请求方法
     *
     * @param user 用户对象
     * @return 登录结果信息
     */
    @Override
    public ResultInfo unSafeLogin(User user) {
        // 获取查询对象
        UserMapper userMapper = MybatisUtil.getSession().getMapper(UserMapper.class);
        // 查询对象进行封装
        UserVO dataUser = userMapper.queryByNameAndPwd(user);
        if (dataUser != null) {
            // 登录成功
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("userInfo", dataUser);
            return ResultInfo.builder()
                    .code(200)
                    .msg("登录成功")
                    .data(resultMap)
                    .build();
        } else {
            return ResultInfo.builder()
                    .code(400)
                    .msg("用户名或密码错误")
                    .build();
        }
    }
}
