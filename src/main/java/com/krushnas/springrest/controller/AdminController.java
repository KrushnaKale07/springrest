package com.krushnas.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krushnas.springrest.pojo.AdminPOJO;
import com.krushnas.springrest.responce.AdminResponce;
import com.krushnas.springrest.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping(path = "/createAccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponce> createAccount(@RequestBody AdminPOJO pojo) {
		AdminPOJO admin = service.createAccount(pojo);

		// Success
		if (admin != null) {
			return new ResponseEntity<AdminResponce>(new AdminResponce("Account Created Successfully", admin),
					HttpStatus.ACCEPTED);
		}

		// Failure
		return new ResponseEntity<AdminResponce>(new AdminResponce("Account not created. ", null),
				HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponce> login(@RequestBody AdminPOJO pojo) {
		AdminPOJO admin = service.login(pojo);

		// Success
		if (admin != null) {
			return new ResponseEntity<AdminResponce>(new AdminResponce("Login Successful. ", admin), HttpStatus.OK);
		}

		// Failure
		return new ResponseEntity<AdminResponce>(new AdminResponce("Login failed", null), HttpStatus.NOT_FOUND);
	}

}
