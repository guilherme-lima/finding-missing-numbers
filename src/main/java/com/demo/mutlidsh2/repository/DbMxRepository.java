package com.demo.mutlidsh2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class DbMxRepository {

    @Autowired
    @Resource(name = "dbMxDataSource")
    private DataSource dataSourcedbMx;

    @PostConstruct
    public void init() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourcedbMx);
        jdbcTemplate.execute("CREATE TABLE Characters (Character varchar(50))");

        for (int i = 25; i < 30; i++) {
            jdbcTemplate.update(String.format("insert into Characters values('%d')", i));
        }
    }

    public List<String> findAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourcedbMx);
        return jdbcTemplate.query("SELECT * FROM Characters",
                (rs, rowNumber) -> rs.getString("Character"));
    }
}
