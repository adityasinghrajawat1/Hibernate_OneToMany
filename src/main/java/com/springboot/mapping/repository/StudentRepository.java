package com.springboot.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mapping.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
