package com.dbs.school.service;

import java.util.List;

import com.dbs.school.model.StudentDetails;

public interface StudentDetailsService {

	boolean deleteById(Long id);

	List<StudentDetails> findAll();

	StudentDetails save(StudentDetails studentDetails);
}
