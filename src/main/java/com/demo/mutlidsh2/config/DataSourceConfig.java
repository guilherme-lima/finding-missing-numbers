package com.demo.mutlidsh2.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.dbBr")
    public DataSource dbBrDataSource() {
        return new DataSource();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.dbAr")
    public DataSource dbArDataSource() {
        return new DataSource();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.dbMx")
    public DataSource dbMxDataSource() {
        return new DataSource();
    }
}
