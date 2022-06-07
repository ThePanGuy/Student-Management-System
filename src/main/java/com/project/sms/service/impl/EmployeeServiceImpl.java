package com.project.sms.service.impl;

import com.project.sms.entity.Employee;
import com.project.sms.repository.EmployeeRepository;
import com.project.sms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
}
