package com.krushnas.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krushnas.springrest.pojo.StudentPOJO;
import com.krushnas.springrest.responce.StudentResponce;
import com.krushnas.springrest.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponce> addStudent(@RequestBody StudentPOJO pojo) {
		StudentPOJO student = service.addStudent(pojo);

		// Success
		if (student != null) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Data added successfully. ", student, null),
					HttpStatus.ACCEPTED);
		}
		// Failure
		return new ResponseEntity<StudentResponce>(new StudentResponce("data not added. ", null, null),
				HttpStatus.ACCEPTED);
	}
}
