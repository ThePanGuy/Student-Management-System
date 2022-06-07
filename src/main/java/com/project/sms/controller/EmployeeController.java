package com.project.sms.controller;

import com.project.sms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
