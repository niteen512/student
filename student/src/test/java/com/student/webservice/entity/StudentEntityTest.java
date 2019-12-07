package com.student.webservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StudentEntityTest {
	@Test
	public void testStudentEntityGettersSetters() {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStudentId((long) 11);
		studentEntity.setFirstName("Niteen");
		studentEntity.setLastName("Lakhe");
		studentEntity.setMarks(75);
		List<AddressEntity> addressEntityList = new ArrayList<>();
		studentEntity.setAddressEntityList(addressEntityList);
		assertEquals(11,studentEntity.getStudentId());
		assertEquals("Niteen",studentEntity.getFirstName());
		assertEquals("Lakhe",studentEntity.getLastName());
		assertEquals(75,studentEntity.getMarks());
		assertNotNull(studentEntity.getAddressEntityList());
		
	}

}

