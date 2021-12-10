package com.example.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 用于Mybatis使用druid连接池，只需要实现DataSourceFactory接口
 * 要求properties参数列表要与指定的第三方连接池参数一致
 * @author youngoo
 * @date 2021/12/10 19:27
 */
public class MybatisDruidDatasource implements DataSourceFactory {
    private Properties properties;

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public DataSource getDataSource() {
        DataSource dataSource = null;
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("数据源初始化失败");
        }
        return dataSource;
    }
}
