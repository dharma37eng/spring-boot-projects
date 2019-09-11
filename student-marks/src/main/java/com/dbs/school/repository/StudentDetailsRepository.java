package com.dbs.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.school.model.StudentDetails;

@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Long> {

}
