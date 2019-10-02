package com.dbs.school.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dbs.school.model.StudentDetails;
import com.dbs.school.repository.StudentDetailsRepository;

/**
 * @author Dharma Teja
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDetailsServiceTest {

	@MockBean
	private StudentDetailsRepository studentDetailsRepository;

	@Autowired
	private StudentDetailsService studentDetailsService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindAll() {
		StudentDetails s1 = new StudentDetails();
		s1.setId(1L);
		s1.setName("Dharma");
		s1.setPercentage(78.72);
		when(studentDetailsRepository.findAll()).thenReturn(Stream.of(s1).collect(Collectors.toList()));
		assertEquals(1, studentDetailsService.findAll().size());
	}

	@Test
	public void testSave() {
		StudentDetails s1 = new StudentDetails();
		s1.setId(100L);
		s1.setName("Dharma");
		s1.setPercentage(78.72);
		when(studentDetailsRepository.save(s1)).thenReturn(s1);
		assertEquals(s1, studentDetailsService.save(s1));
	}

	@Test
	public void testDeleteById() {
		doNothing().when(studentDetailsRepository).deleteById(Mockito.anyLong());
		//verify(studentDetailsRepository, times(1)).deleteById(Mockito.anyLong());
	}

}
