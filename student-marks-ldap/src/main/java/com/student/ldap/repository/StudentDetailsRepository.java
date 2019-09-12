package com.student.ldap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.ldap.model.StudentDetails;

@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Long> {

}
