package com.cyberoxi.sevadathink.bootstrap;

import com.cyberoxi.sevadathink.model.Employee;
import com.cyberoxi.sevadathink.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public DbSeeder(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initData();
    }

    private void initData(){

        Employee employee = new Employee();

        employee.setFirstName("Amir");
        employee.setEmail("cnooed@gmail.com");

        employeeRepository.save(employee);

    }

}
