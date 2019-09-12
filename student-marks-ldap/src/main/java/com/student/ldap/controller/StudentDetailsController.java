package com.student.ldap.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.student.ldap.model.StudentDetails;
import com.student.ldap.repository.StudentDetailsRepository;
import com.student.ldap.service.StudentDetailsService;

@RestController
public class StudentDetailsController {

	@Autowired
	private StudentDetailsRepository studentDetailsRepository;

	@Autowired
	private StudentDetailsService studentDetailsService;

	@GetMapping("/get-all-studentdetails")
	public List<StudentDetails> getAllStudentDetails() {
		return studentDetailsRepository.findAll();
	}

	@PostMapping("/save-studentdetails")
	public ResponseEntity<StudentDetails> saveStudentDetails(@RequestBody StudentDetails studentDetails) {
		StudentDetails student = studentDetailsRepository.save(studentDetails);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(student.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/delete-student/{id}")
	public ResponseEntity<StudentDetails> deleteStudentDetails(@PathVariable Long id) {
		boolean deleteById = studentDetailsService.deleteById(id);
		return deleteById ? 
				new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

}
