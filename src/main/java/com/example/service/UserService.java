package com.example.service;

import com.example.entities.PO.User;
import com.example.entities.Query.QueryUser;
import com.example.utils.ResultInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @author youngoo
 * @date 2021/12/11 17:33
 */
public interface UserService {

    /**
     * 数据库密码没有进行加密的登录请求方法
     * @param user 用户对象
     * @param request 请求对象
     * @return 登录结果信息
     */
    public ResultInfo unSafeLogin(User user, HttpServletRequest request);

    /**
     * 查询所有角色信息
     * @return 查询到的结果信息
     */
    ResultInfo getRoleList();

    /**
     * 查询所有的用户列表
     * @param page 当前页
     * @param limit 分页大小
     * @return 结果信息
     */
    ResultInfo getUserList(String page, String limit);

    /**
     * 添加用户的方法，根据用户信息和角色id，分别进行插入操作
     * @param userInfo 用户信息
     * @param roleId 角色id
     * @return 统一返回格式
     */
    ResultInfo addUser(User userInfo, int roleId);

    /**
     * 条件查询用户信息
     * @param queryUser 查询条件
     * @return 统一返回对象
     */
    ResultInfo getUserList(QueryUser queryUser);

    /**
     * 修改用户信息
     * @param user 用户对象
     * @param roleId 角色id
     * @return 统一返回对象
     */
    ResultInfo updateUser(User user, int roleId);

    /**
     * 删除用户
     * @param userId 用户id
     * @return 统一返回对象
     */
    ResultInfo delUser(int userId);
}
