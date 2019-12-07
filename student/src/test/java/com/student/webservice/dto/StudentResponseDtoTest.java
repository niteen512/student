package com.student.webservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StudentResponseDtoTest {

	private static final String _200_OK = "200 OK";
	private static final String MESSAGE = "message";

	@Test
	public void testConstructor() {
		StudentRequestDto studentRequestDto = getStudentRequestDto();
		StudentResponseDto studentResponseDto = new StudentResponseDto(studentRequestDto,MESSAGE,_200_OK);
		assertEquals(studentRequestDto, studentResponseDto.getStudentRequestDto());
		assertEquals(MESSAGE,studentResponseDto.getMessage());
		assertEquals(_200_OK, studentResponseDto.getStatus());
	}
	
	@Test
	public void testGeterSetters() {
		StudentRequestDto studentRequestDto = getStudentRequestDto();
		StudentResponseDto studentResponseDto = new StudentResponseDto(null,null,null);
		studentResponseDto.setStudentRequestDto(studentRequestDto);
		studentResponseDto.setMessage(MESSAGE);
		studentResponseDto.setStatus(_200_OK);
		assertEquals(studentRequestDto, studentResponseDto.getStudentRequestDto());
		assertEquals(MESSAGE,studentResponseDto.getMessage());
		assertEquals(_200_OK, studentResponseDto.getStatus());
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
