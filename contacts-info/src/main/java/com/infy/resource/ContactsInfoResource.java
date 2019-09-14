package com.infy.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.exception.ContactNotFoundException;
import com.infy.model.Contact;
import com.infy.repository.ContactInfoRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/contacts-info")
public class ContactsInfoResource {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactsInfoResource.class);

	@Autowired
	private ContactInfoRepository contactInfoRepository;
	
	@GetMapping("/all-contacts")
	@ApiOperation(value = "Get all the contacts List",
	notes = "Finds all the contacts", response = List.class)
	public List<Contact> getAllContacts() {
		logger.info("Entering " + Thread.currentThread().getStackTrace()[1].getMethodName() + " method");
		return contactInfoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get the contact by Id",
	notes = "Provide an Id to lookup in the contacts-info database", response = Contact.class)
	public Contact getContactById(@ApiParam(value = "Id value required to retrieve contact", required = true)
									@PathVariable("id") Long id) {
		logger.info("Entering " + Thread.currentThread().getStackTrace()[1].getMethodName() + " method");
		return contactInfoRepository.findById(id).orElseThrow(() -> new ContactNotFoundException("Contact not found"));
	}
	
	@PostMapping("/save-contact")
	@ApiOperation(value = "saves the contact information",
	notes = "Provide the contact request to save to contacts-info database", response = Contact.class)
	public Contact saveContact(@RequestBody Contact contact) {
		logger.info("Entering " + Thread.currentThread().getStackTrace()[1].getMethodName() + " method");
		return contactInfoRepository.save(contact);
	}
}
