package com.project.sms.controller;

import com.project.sms.entity.Student;
import com.project.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;

    //handler method to handle list students
    // and return mode and view
    @GetMapping("/students")
    public String listStudent(Model model) {
        model.addAttribute("students",service.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        //create student object to  hold student form data
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";

    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm( @PathVariable Long id,Model model) {
        model.addAttribute("student",service.getStudentById(id));
        return "edit_student";

    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable  Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {
        // get student from database by id
        Student existingStudent = service.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //save updated student object
        service.updateStudent(existingStudent);
        return "redirect:/students";
    }
}
