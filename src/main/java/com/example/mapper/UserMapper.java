package com.example.mapper;

import com.example.entities.PO.User;
import com.example.entities.Query.QueryUser;
import com.example.entities.VO.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 统计用户数量
     * @param index 索引
     * @param size 查询条数
     * @return 统计数量
     */
    int countUser(@Param("index") int index, @Param("size") int size);

    /**
     * 分页查询所有的用户信息
     * @param index 索引位置
     * @param size 分页大小
     * @return 查询到的所有用户数据
     */
    List<UserVO> queryAll(@Param("index") int index, @Param("size") int size);

    /**
     * 向用户表插入一条新的信息
     * @param userInfo 用户信息对象
     * @return 插入的id
     */
    int insertUser(User userInfo);

    /**
     * 条件查询所有用户信息
     * @param queryUser 查询条件
     * @return 用户列表
     */
    List<UserVO> queryAllUser(QueryUser queryUser);

    /**
     * 条件统计用户数量
     * @param queryUser 查询条件
     * @return 用户数量
     */
    int countUserAll(QueryUser queryUser);

    /**
     * 更新用户信息
     * @param user 用户对象
     * @return 受影响的行数
     */
    int updateUser(User user);

    /**
     * 根据用户id删除该记录
     * @param userId 用户id
     * @return 受影响的行数
     */
    int delUserById(int userId);

    /**
     * 检查是否有相同的用户，只对用户名进行判别
     * @param userInfo 用户信息
     * @return 用户对象
     */
    UserVO queryByName(User userInfo);
}
