package com.infy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Details of the Contact")
public class Contact {

	@Id
	@GeneratedValue
	@ApiModelProperty(notes = "Unique Id")
	private Long id;
	@ApiModelProperty(notes = "Name of the contact")
	private String contactName;
	@ApiModelProperty(notes = "mobile # of the contact")
	private Long mobileNumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", contactName=" + contactName + ", mobileNumber=" + mobileNumber + "]";
	}
}
