package com.example.service;

import com.example.entities.PO.User;
import com.example.utils.ResultInfo;

/**
 * @author youngoo
 * @date 2021/12/11 17:33
 */
public interface UserService {

    /**
     * 数据库密码没有进行加密的登录请求方法
     * @param user 用户对象
     * @return 登录结果信息
     */
    public ResultInfo unSafeLogin(User user);

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
}
