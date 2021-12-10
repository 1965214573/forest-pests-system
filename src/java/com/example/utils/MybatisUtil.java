package com.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 简单的Mybatis工具类，用来获取会话对象（SqlSession）
 * @author youngoo
 * @date 2021/12/10 20:41
 */
public class MybatisUtil {

    /**
     * 根据配置文件创建的SqlSessionFactory
     */
    private static final SqlSessionFactory SQL_SESSION_FACTORY;

    static {
        // 初始化当前SqlSessionFactory
        SQL_SESSION_FACTORY = xmlCreateSqlSessionFactory();
    }

    /**
     * 工具内部调用的方法，通过xml配置文件来创建SqlSessionFactoryBuilder，
     * 再通过SqlSessionFactoryBuilder的build方法，创建SqlSessionFactory对象
     * @return sqlSessionFactory 创建好的SqlSessionFactory对象，用来创建SqlSession
     */
    private static SqlSessionFactory xmlCreateSqlSessionFactory() {
        InputStream inputStream = null;
        String configFilePath = "config/mybatis-config.xml";
        try {
            inputStream = Resources.getResourceAsStream(configFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("找不到配置文件:" + configFilePath + "\t请检查文件是否存在！");
        }
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 创建一个如下规则的SqlSession
     * 默认的 openSession() 方法没有参数，它会创建具备如下特性的 SqlSession：
     *
     * 事务作用域将会开启（也就是不自动提交）。
     * 将由当前环境配置的 DataSource 实例中获取 Connection 对象。
     * 事务隔离级别将会使用驱动或数据源的默认设置。
     * 预处理语句不会被复用，也不会批量处理更新。
     * @return sqlSession 返回创建好的会话对象
     */
    public static SqlSession getSession() {
        return SQL_SESSION_FACTORY.openSession();
    }

    /**
     * 创建自动提交事务的session
     * @param autoCommit 是否进行事务的自动提交
     * @return 返回一个SqlSession
     */
    public static SqlSession getSession(boolean autoCommit) {
        return SQL_SESSION_FACTORY.openSession(autoCommit);
    }
}
