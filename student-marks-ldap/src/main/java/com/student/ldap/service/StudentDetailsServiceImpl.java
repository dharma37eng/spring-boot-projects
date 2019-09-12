package com.student.ldap.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.ldap.model.StudentDetails;
import com.student.ldap.repository.StudentDetailsRepository;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService {

	@Autowired
	private StudentDetailsRepository studentDetailsRepository;

	@Override
	public boolean deleteById(Long id) {
		Optional<StudentDetails> studentDetailsById = studentDetailsRepository.findById(id);
		if (studentDetailsById.isPresent()) {
			studentDetailsRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
