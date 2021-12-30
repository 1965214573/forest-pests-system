package com.example.service.impl;

import com.example.entities.PO.Log;
import com.example.entities.PO.Role;
import com.example.entities.PO.User;
import com.example.entities.Query.QueryUser;
import com.example.entities.VO.UserVO;
import com.example.mapper.LogMapper;
import com.example.mapper.RoleMapper;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import com.example.utils.SnowIdUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author youngoo
 * @date 2021/12/11 17:34
 */
public class UserServiceImpl implements UserService {
    private final Logger logger = Logger.getLogger(this.getClass());
    /**
     * 数据库密码没有进行加密的登录请求方法
     *
     * @param user 用户对象
     * @param request 请求对象
     * @return 登录结果信息
     */
    @Override
    public ResultInfo unSafeLogin(User user, HttpServletRequest request) {
        // 获取查询对象
        UserMapper userMapper = MybatisUtil.getSession().getMapper(UserMapper.class);
        // 查询对象进行封装
        UserVO dataUser = userMapper.queryByNameAndPwd(user);
        if (dataUser != null) {
            // 登录成功
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60 * 30);
            String token = UUID.randomUUID().toString();
            session.setAttribute(token, dataUser);
            HashMap<String, Object> resultMap = new HashMap<>(2);
            resultMap.put("token", token);
            resultMap.put("userInfo", dataUser);

            try (SqlSession sqlSession = MybatisUtil.getSession()) {
                LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
                Log log = new Log(SnowIdUtils.uniqueLong(), dataUser.getRealName() + "登陆了系统", LocalDateTime.now());
                if (logMapper.insertLog(log) != 0) {
                    sqlSession.commit();
                }
            } catch (Exception e) {
                logger.error("数据库操作异常", e);
            }


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

            // 查重
            UserMapper userMapper = session.getMapper(UserMapper.class);
            UserVO userVO = userMapper.queryByName(userInfo);
            if (userVO == null) {
                // 添加用户
                if (userMapper.insertUser(userInfo) != 0) {
                    RoleMapper roleMapper = session.getMapper(RoleMapper.class);
                    if (roleMapper.insertUser(userInfo.getUserId(), roleId) != 0) {
                        session.commit();
                        return ResultInfo.ok();
                    }
                }
            }
        } catch (Exception e) {
            logger.error("数据库操作失败", e);
        }
        return ResultInfo.err();

    }

    /**
     * 条件查询用户信息
     *
     * @param queryUser 查询条件
     * @return 统一返回对象
     */
    @Override
    public ResultInfo getUserList(QueryUser queryUser) {
        try(SqlSession session = MybatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            int count = mapper.countUserAll(queryUser);
            HashMap<String, Object> data = new HashMap<>(2);
            data.put("count", count);
            if (count != 0) {
                List<UserVO> userVOList = mapper.queryAllUser(queryUser);
                data.put("userList", userVOList);
            }

            return ResultInfo.builder()
                    .code(200)
                    .msg("用户信息列表")
                    .data(data)
                    .build();
        } catch (Exception e) {
            logger.error("数据库操作异常", e);
        }
        return ResultInfo.err();
    }

    /**
     * 修改用户信息
     *
     * @param user   用户对象
     * @param roleId 角色id
     * @return 统一返回对象
     */
    @Override
    public ResultInfo updateUser(User user, int roleId) {
        try (SqlSession session = MybatisUtil.getSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            if (userMapper.updateUser(user) != 0) {
                RoleMapper roleMapper = session.getMapper(RoleMapper.class);
                if (roleMapper.updateUserRole(user.getUserId(), roleId) != 0) {
                    session.commit();
                    return ResultInfo.ok();
                }
            }
        } catch (Exception e) {
            logger.error("数据库操作失败", e);
        }
        return ResultInfo.err();
    }

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return 统一返回对象
     */
    @Override
    public ResultInfo delUser(int userId) {
        try (SqlSession session = MybatisUtil.getSession()){
            UserMapper mapper = session.getMapper(UserMapper.class);
            if (mapper.delUserById(userId) != 0) {
                session.commit();
                return ResultInfo.ok();
            }
        } catch (Exception e) {
            logger.error("数据库操作异常", e);
        }
        return ResultInfo.err();
    }
}
