package com.example.demo;

import com.example.demo.configuration.DatabaseConfiguration;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class, DatabaseConfiguration.class})
public class EmployeeServiceIntegrationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void shouldRetrieveOneEmployee(){
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        Employee employee = employeeService.findEmployeeBy(1);

        Assert.assertThat(employee.getId(),is(1));
        Assert.assertThat(employee.getName(),is("Jonatan"));

    }
}
