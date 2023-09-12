package com.krushnas.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krushnas.springrest.pojo.StudentPOJO;
import com.krushnas.springrest.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public StudentPOJO addStudent(StudentPOJO pojo) {
		StudentPOJO student = repository.addStudent(pojo);
		return student;
	}
	
	public StudentPOJO searchStudent(int id) {
		StudentPOJO student = repository.searchStudent(id);
		return student;
	}

}
