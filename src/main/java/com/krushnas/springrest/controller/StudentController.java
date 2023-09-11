package com.krushnas.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.krushnas.springrest.pojo.StudentPOJO;
import com.krushnas.springrest.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping(path = "/add",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void addStudent(@RequestBody StudentPOJO pojo) {
		StudentPOJO student = service.addStudent(pojo);

		// Success
		if (student != null) {

		}

		// Failure
	}
}
