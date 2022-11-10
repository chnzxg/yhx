package cn.chnzxg.yhx.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author zhout 2021/10/27 11:17
 */
@Configuration
@Log
public class DataSourceConfig {

    private String url = "jdbc:postgresql://localhost:5432/yhx";
    private String username = "postgres";
    private String password = "postgres";

    @Bean
    @Primary
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();

        // 基本属性
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataSource.setUseUnfairLock(true);

        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(60000);

        // 配置一个连接在池中最小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(300000);

        // 配置连接检测的策略，在连接空闲时检测
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setTestWhileIdle(true);

        return dataSource;
    }


    @Bean(name = "jdbcTemplate")
    @Primary
    public JdbcTemplate dataJdbcTemplate(
    ) throws SQLException {
        DataSource dataSource = dataSource();
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
