package com.example.service.impl;

import com.example.entities.PO.Role;
import com.example.entities.PO.User;
import com.example.entities.VO.UserVO;
import com.example.mapper.RoleMapper;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

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
            HashMap<String, Object> resultMap = new HashMap<>(1);
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

    /**
     * 查询所有角色信息
     *
     * @return 查询到的结果信息
     */
    @Override
    public ResultInfo getRoleList() {
        try(SqlSession session = MybatisUtil.getSession()) {
            RoleMapper mapper = session.getMapper(RoleMapper.class);
            List<Role> roleList = mapper.selectAll();
            HashMap<String, Object> result = new HashMap<>(1);
            result.put("roleList", roleList);
            return ResultInfo.builder()
                    .code(200)
                    .msg("角色信息")
                    .data(result)
                    .build();
        }
    }

    /**
     * 查询所有的用户列表
     *
     * @return 结果信息
     * @param page 页码
     * @param limit 每页条数
     */
    @Override
    public ResultInfo getUserList(String page, String limit) {
        try(SqlSession session = MybatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            int p = 1;
            int s = 10;
            if (page != null) {
                p = Integer.parseInt(page);
                s = Integer.parseInt(limit);
            }

            int count = mapper.countUser((p - 1) * s, s);

            List<UserVO> userVOList = mapper.queryAll((p - 1) * s, s);
            HashMap<String, Object> result = new HashMap<>(2);
            result.put("count", count);
            result.put("userList", userVOList);
            return ResultInfo.builder()
                    .code(200)
                    .msg("用户信息列表")
                    .data(result)
                    .build();
        }
    }

    /**
     * 添加用户的方法，根据用户信息和角色id，分别进行插入操作
     *
     * @param userInfo 用户信息
     * @param roleId     角色id
     * @return 统一返回格式
     */
    @Override
    public ResultInfo addUser(User userInfo, int roleId) {
        try(SqlSession session = MybatisUtil.getSession()) {
            // 添加用户
            UserMapper userMapper = session.getMapper(UserMapper.class);
            int resultRow = userMapper.insertUser(userInfo);
            RoleMapper roleMapper = session.getMapper(RoleMapper.class);
            resultRow = roleMapper.insertUser(userInfo.getUserId(), roleId);
            session.commit();
            return ResultInfo.ok();
        } catch (Exception e) {
            return ResultInfo.err();
        }

    }
}
