package com.springboot.mapping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mapping.model.Student;
import com.springboot.mapping.repository.AddressRepository;
import com.springboot.mapping.repository.StudentRepository;


@Service
public class StudentService {

	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public Student saveAllStudent(Student Stud)
	{
		
		return studentRepo.save(Stud); 
	}
	
	public List<Student> getAllStudent()
	{
		return studentRepo.findAll();
	}
	
	public boolean deleteStudent(Long id)
	{
		if(studentRepo.findById(id).isPresent())
		{
			studentRepo.deleteById(id);
			return true;
		}
		
		throw new IllegalArgumentException("No Student Found with id :"+id );
		
	}
	
	public Optional<Student> getStudentById(Long id)
	{
		return studentRepo.findById(id);
	}
	
	public Student UpdateStudent(Student student,Long id)
	{
		Optional<Student> optionalStudent = studentRepo.findById(id);
		
		if(optionalStudent.isPresent())
		{
			Student student2 = optionalStudent.get();
			
			student2.setName(student.getName());
			return studentRepo.save(student2);
		}
		throw new IllegalArgumentException("No Student Found with id : "+id);
	}
	
}
