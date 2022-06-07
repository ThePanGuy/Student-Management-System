package com.project.sms.controller;

import com.project.sms.entity.Employee;
import com.project.sms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm (@PathVariable Long id,Model model) {
        model.addAttribute("employee",service.getEmployeeById(id));
        return "edit_employee";
    }

    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id,@ModelAttribute Employee employee) {
        //updating the existing employee
        Employee existingEmployee = service.getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setMiddleName(employee.getMiddleName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());

        //saving him in the repository
        service.updateEmployee(existingEmployee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    @GetMapping("/employees/details/{id}")
    public String detailsEmployee(@PathVariable Long id,Model model) {
        model.addAttribute("employee",service.getEmployeeById(id));
        return "details_employee";
    }
}
