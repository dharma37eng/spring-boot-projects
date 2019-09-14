package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.model.Contact;

public interface ContactInfoRepository extends JpaRepository<Contact, Long> {

}
