package com.project.sms.controller;

import com.project.sms.entity.Employee;
import com.project.sms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    //method to return the list of students
    @GetMapping("/employees")
    public String listEmployee(Model model) {
        model.addAttribute("employees",service.getAllEmployees());
        return "employees";
    }

    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model) {
        //create student object to hold the data for the employee form
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "create_employee";
    }
    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/employees";
    }
}
