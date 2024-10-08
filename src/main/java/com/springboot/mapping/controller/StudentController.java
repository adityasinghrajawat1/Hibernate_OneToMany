package com.springboot.mapping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mapping.model.Student;
import com.springboot.mapping.service.StudentService;


@RestController
public class StudentController {

	@Autowired
	StudentService studService;
	
	@GetMapping("start")
	public String getSatrted()
	{
		return "Starting..........";
	}
	

    @PostMapping("student/save")
    public Student savAllStudent(@RequestBody Student student)
    {
    	return studService.saveAllStudent(student);
    }
    
    @GetMapping("student/getAll")
    public List<Student> getAllStudent()
    {
    	return studService.getAllStudent();
    }
    
    @DeleteMapping("student/delete/{id}")
    public String deleteStudent(@PathVariable Long id)
    {
    	studService.deleteStudent(id);
    	return "Student removed with id : "+id;
    }
    
    @GetMapping("student/getById/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id)
    {
    	return studService.getStudentById(id);
    }
    
    @PutMapping("student/update/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable Long id)
    {
    	return studService.UpdateStudent(student, id);
    }
	
	
}
