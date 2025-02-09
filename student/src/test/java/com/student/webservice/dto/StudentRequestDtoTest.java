package com.student.webservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StudentRequestDtoTest {
	@Test
	public void testStudentGettersSetters() {
		StudentRequestDto student = new StudentRequestDto();
		student.setStudentId((long) 11);
		student.setFirstName("Niteen");
		student.setLastName("Lakhe");
		student.setMarks(75);
		List<Address> addressList = new ArrayList<>();
		student.setAddressList(addressList);
		assertEquals(11,student.getStudentId());
		assertEquals("Niteen",student.getFirstName());
		assertEquals("Lakhe",student.getLastName());
		assertEquals(75,student.getMarks());
		assertNotNull(student.getAddressList());
		
	}

}
