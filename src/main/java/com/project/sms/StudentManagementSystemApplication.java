package com.project.sms;

import com.project.sms.repository.EmployeeRepository;
import com.project.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student("Pantelis","Nikolidakis","pantelis@gmail.com");
//		studentRepository.save(student1);
//
//		Student student2 = new Student("Petros","Zantiotis","petros@gmail.com");
//		Student student3 = new Student("Dinos","Kanakakis","lediin@gmail.com");
//		studentRepository.save(student2);
//		studentRepository.save(student3);
//		Employee employee1 = new Employee("Evelyn",null,"Tairidi","evelina@gmail.com","ST");
//		Employee employee2 = new Employee("Olga",null,"Makridaki","olga@hotmail.com","TC");
//		employeeRepository.save(employee1);
//		employeeRepository.save(employee2);


	}
}
