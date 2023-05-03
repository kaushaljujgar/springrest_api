package com.jspiders.springmvc5.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springmvc5.base.pojo.StudentPojo;
import com.jspiders.springmvc5.base.response.StudentResponse;
import com.jspiders.springmvc5.base.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping(path ="/add",consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse>addStudent(@RequestBody StudentPojo student){
		
		StudentPojo pojo=service.add(student);
		if (pojo != null) {
			//success
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("SUCCESS", "Student added successfully",
					pojo, null), HttpStatus.OK);
		}
		//failure
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("FAILURE", "Student not added",
				null, null), HttpStatus.BAD_REQUEST);
	}
		
		
	}


