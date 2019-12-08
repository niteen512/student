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

public class UpdateMapperHelperImplTest {

	@InjectMocks
	UpdateMapperHelperImpl updateMapperHelperImpl;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMergeExistingAndNew() {
		StudentEntity studentEntity = getStudentEntity();
		assertEquals(1, updateMapperHelperImpl.mergeExistingAndNew(studentEntity, studentEntity).getStudentId());
	}
	
	@Test
	public void testMergeExistingAndNewDifferentAddressId() {
		StudentEntity studentEntity = getStudentEntity();
		StudentEntity studentEntity1 = getStudentEntity();
		studentEntity1.getAddressEntityList().get(0).setAddressId(2L);
		assertEquals(1, updateMapperHelperImpl.mergeExistingAndNew(studentEntity, studentEntity1).getStudentId());
	}
	
	@Test
	public void testMergeExistingAndNewWhenExistingEntityNull() {
		StudentEntity entity = null;
		StudentEntity studentEntity = getStudentEntity();
		assertEquals(1, updateMapperHelperImpl.mergeExistingAndNew(entity, studentEntity).getStudentId());
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
