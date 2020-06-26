package com.chuanhao.blog.config.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * 配置datasource到ioc容器里面
 */
@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.chuanhao.blog.dao")
public class DataSourceConfigration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    /**
     * 生成与pring-dao.xml对应的bean dateSource
     */
    @Bean(name = "dataSource")
    public DruidDataSource createDateSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        //跟配置文件一样设置以下信息
        //驱动
        dataSource.setDriverClassName(jdbcDriver);
//        dataSource.setDriver(jdbcDriver);
        //设置url
        dataSource.setUrl(jdbcUrl);
        //账户
        dataSource.setUsername(jdbcUsername);
        //密码
        dataSource.setPassword(jdbcPassword);
        //关闭链接后不自动commit
        dataSource.setDefaultAutoCommit(false);
        //链接超时时间
        dataSource.setQueryTimeout(10000);
        //配置初始化大小、最小、最大
        dataSource.setInitialSize(1);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(20);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        //配置一个连接在池中最小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(300000);

        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestOnBorrow(true);
        //打开PSCache，并且指定每个连接上PSCache的大小
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        //配置监控统计拦截的filters，去掉后监控界面sql无法统计
        dataSource.setFilters("stat");


        return dataSource;
    }

}
