/**
 * 
 */
package com.dbs.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dbs.school.model.StudentDetails;
import com.dbs.school.service.StudentDetailsService;

/**
 * @author Dharma Teja
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentDetailsController.class, secure = false)
@AutoConfigureMockMvc
public class StudentDetailsControllerTest {

	@MockBean
	private StudentDetailsService studentDetailsService;

	@InjectMocks
	private StudentDetailsController studentDetailsController;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webAppContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

	/**
	 * Test method for
	 * {@link com.student.ldap.controller.StudentDetailsController#getAllStudentDetails()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetAllStudentDetails() throws Exception {

		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setId(1L);
		studentDetails.setName("Dharma");
		studentDetails.setPercentage(78.72);

		List<StudentDetails> allStudentDetails = new ArrayList<>();
		allStudentDetails.add(studentDetails);

		BDDMockito.given(studentDetailsService.findAll()).willReturn(allStudentDetails);
		mockMvc
		.perform(MockMvcRequestBuilders.get("/get-all-studentdetails").accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is(studentDetails.getName())));
		//String expected = "[{id:1,name:Dharma,percentage:78.72}]";
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	/**
	 * Test method for
	 * {@link com.student.ldap.controller.StudentDetailsController#saveStudentDetails(com.student.ldap.model.StudentDetails)}.
	 */
	/*
	 * @Test void testSaveStudentDetails() { fail("Not yet implemented"); }
	 */

	/**
	 * Test method for
	 * {@link com.student.ldap.controller.StudentDetailsController#deleteStudentDetails(java.lang.Long)}.
	 */
	/*
	 * @Test void testDeleteStudentDetails() { fail("Not yet implemented"); }
	 */

}
