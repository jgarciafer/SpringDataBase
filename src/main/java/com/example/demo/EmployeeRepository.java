package com.example.demo;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
    }

    public Employee findEmployeeBy(int id) {


        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);

        String sql = "SELECT * FROM EMPLOYEE WHERE ID = :id";

        List<Employee> employeeEntity = this.namedParameterJdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Employee.class));

        return employeeEntity.get(0);
    }

}
