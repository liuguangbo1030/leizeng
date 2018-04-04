package com.udp.nb;

import com.alibaba.druid.pool.DruidDataSource;

import com.udp.nb.context.ServiceUtil;
import com.udp.nb.service.NettyService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @version 1.0
 * @date 2017/1/21.
 */
@SpringBootApplication
@MapperScan("com.udp.nb.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        NettyService nettyService = (NettyService)ServiceUtil.getBean("nettyService");
        nettyService.start();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/conf-mapper/*.xml"));
        return sessionFactory.getObject();
    }
}
