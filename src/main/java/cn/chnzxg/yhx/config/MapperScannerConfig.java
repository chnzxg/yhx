package cn.chnzxg.yhx.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * @author chnzxg
 * @date 2018/7/6.
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("cn.chnzxg.yhx.mapper");
        mapperScannerConfigurer.setMarkerInterface(BaseMapper.class);
        Properties properties = new Properties();
        properties.setProperty("mappers", "cn.chnzxg.yhx.config.BaseMapper");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}
