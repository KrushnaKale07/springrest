package com.krushnas.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
				HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping(path = "/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponce> searchStudent(@PathVariable int id) {
		StudentPOJO student = service.searchStudent(id);

		// Success
		if (student != null) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Data Found Successfully. ", student, null),
					HttpStatus.FOUND);
		}
		// Failure
		return new ResponseEntity<StudentResponce>(new StudentResponce("Data Not found. ", student, null),
				HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/searchAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponce> searchAllStudents() {
		List<StudentPOJO> students = service.searchAllStudent();

		// Success
		if (students.isEmpty() == false) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Data found Succecfully. ", null, students),
					HttpStatus.FOUND);
		}

		// Failure
		return new ResponseEntity<StudentResponce>(new StudentResponce("Data not found, ", null, null),
				HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/remove/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponce> removeStudent(@PathVariable int id) {
		StudentPOJO student = service.removeStudent(id);

		// Success
		if (student != null) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Data Remove Successfully", student, null),
					HttpStatus.FOUND);
		}

		// Failure
		return new ResponseEntity<StudentResponce>(new StudentResponce("DAta Not Found", student, null),
				HttpStatus.NOT_FOUND);
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponce> updateStudent(@RequestBody StudentPOJO pojo) {
		StudentPOJO student = service.updateStudent(pojo);

		// Success
		if (student != null) {
			return new ResponseEntity<StudentResponce>(
					new StudentResponce("Data updated successfully. ", student, null), HttpStatus.ACCEPTED);
		}

		// Failure
		return new ResponseEntity<StudentResponce>(new StudentResponce("Data not updated ", null, null),
				HttpStatus.NOT_ACCEPTABLE);
	}
}
