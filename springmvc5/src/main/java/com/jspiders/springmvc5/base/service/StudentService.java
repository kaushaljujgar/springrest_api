package com.jspiders.springmvc5.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc5.base.pojo.StudentPojo;
import com.jspiders.springmvc5.base.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
private StudentRepository repository;

	public StudentPojo add(StudentPojo student) {
		StudentPojo pojo=repository.add(student);
		return pojo;
	}

}
