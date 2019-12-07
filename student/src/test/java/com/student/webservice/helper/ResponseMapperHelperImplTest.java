package com.student.webservice.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.student.webservice.dto.Address;
import com.student.webservice.dto.StudentRequestDto;
import com.student.webservice.entity.AddressEntity;
import com.student.webservice.entity.StudentEntity;

public class ResponseMapperHelperImplTest {

	@InjectMocks
	ResponseMapperHelperImpl responseMapperHelperImpl;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMapStudentToStudentEntity() {
		StudentRequestDto studentRequestDto = getStudentRequestDto();
		assertEquals(1, responseMapperHelperImpl.mapStudentToStudentEntity(studentRequestDto).getStudentId());
	}
	
	
	private StudentRequestDto getStudentRequestDto() {
		StudentRequestDto studentRequestDto = new StudentRequestDto();
		studentRequestDto.setStudentId(1L);
		List<Address>addressList = new ArrayList<>();
		Address address = new Address();
		address.setAddressId(1L);
		addressList.add(address);
		studentRequestDto.setAddressList(addressList);
		return studentRequestDto;
	}
	
	
}
