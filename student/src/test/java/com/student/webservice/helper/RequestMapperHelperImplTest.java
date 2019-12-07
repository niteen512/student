package com.student.webservice.helper;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.student.webservice.entity.AddressEntity;
import com.student.webservice.entity.StudentEntity;

public class RequestMapperHelperImplTest {
	@InjectMocks
	RequestMapperHelperImpl requestMapperHelperImpl;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMapStudentEntityToStudentResponseDto() {
		StudentEntity studentEntity = getStudentEntity();
		assertEquals(1, requestMapperHelperImpl.mapStudentEntityToStudentResponseDto(studentEntity).getStudentId());
	}

	private StudentEntity getStudentEntity() {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStudentId(1L);
		List<AddressEntity>addressEntityList = new ArrayList<>();
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddressId(1L);
		addressEntityList.add(addressEntity);
		studentEntity.setAddressEntityList(addressEntityList);
		return studentEntity;
	}
}
