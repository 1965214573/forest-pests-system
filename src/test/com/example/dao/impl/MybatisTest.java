package com.example.dao.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.example.entities.PO.Menu;
import com.example.mapper.CommonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author youngoo
 * @date 2021/12/10 18:23
 */
public class MybatisTest {



    static SqlSessionFactory xmlCreateSqlSessionFactory() throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    static SqlSessionFactory configClassCreateSqlSessionFactory() {

        Properties properties = new Properties();
        try {
            properties.load(Resources.getResourceAsStream("config/druid-config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            JdbcTransactionFactory transactionFactory = new JdbcTransactionFactory();
            Environment environment = new Environment("development", transactionFactory, dataSource);
            Configuration configuration = new Configuration(environment);
            configuration.addMappers("com.example.mapper");
            configuration.addMappers("config.mapper");
            return new SqlSessionFactoryBuilder().build(configuration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory = xmlCreateSqlSessionFactory();
        assert sqlSessionFactory != null;
        try (SqlSession session = sqlSessionFactory.openSession()) {

            CommonMapper mapper = session.getMapper(CommonMapper.class);
            List<Menu> rootMenuList = mapper.getRootMenuList(1);
            for (Menu menu : rootMenuList) {
                System.out.println(menu);
            }
        }
    }
}
