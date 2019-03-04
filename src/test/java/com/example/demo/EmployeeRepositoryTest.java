package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.is;

public class EmployeeRepositoryTest {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Before
    public void setUp(){
        dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("db/sql/schema.sql")
                .addScript("db/sql/data.sql")
                .build();
    }

    @Test
    public void shouldRetrieveOneEmployee() {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        EmployeeRepository employeeRepository = new EmployeeRepository(jdbcTemplate);

        Employee employee = employeeRepository.findEmployeeBy(1);

        Assert.assertThat(employee.getId(),is(1));
        Assert.assertThat(employee.getName(),is("Jonatan"));
    }



}
