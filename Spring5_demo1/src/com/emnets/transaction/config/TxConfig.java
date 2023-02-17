package com.emnets.transaction.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author lannisite
 * @program TxConfig
 * @description 描述
 * @date 2023/2/17 11:47
 */

@Configuration  // 配置类
@ComponentScan(basePackages = "com.emnets.transaction")     //组建扫描
@EnableTransactionManagement        //  开启事务
public class TxConfig {

    //  创建数据库连接池
    @Bean
    public DruidDataSource getDruidDataSource(){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/user_db?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("q1i9l9i9n");
        return dataSource;
    }

    //  创建Jdbc模版对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){     //  注意这里没有创建dataSource对象就之间调用了，和AutoWired原理类似

        //  到IOC容器中根据类型找到dataSource
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        //  注入dataSource
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }



    //  创建事务管理器的对象
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){

        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}
