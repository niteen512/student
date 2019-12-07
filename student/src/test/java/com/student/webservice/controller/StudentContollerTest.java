package com.student.webservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.student.webservice.dto.Address;
import com.student.webservice.dto.StudentRequestDto;
import com.student.webservice.dto.StudentResponseDto;
import com.student.webservice.dto.StudentServiceImpl;

public class StudentContollerTest {

	@Mock
	StudentServiceImpl studentServiceImpl;
	
	@InjectMocks
	StudentContoller studentContoller;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetStudentInfo() {
		StudentResponseDto studentResponseDto = getStudentResponseDto();
		when(studentServiceImpl.retrieveStudentInfo(Mockito.anyLong())).thenReturn(studentResponseDto);
		StudentResponseDto response = studentContoller.getStudentInfo(1L);
		assertEquals(1, response.getStudentRequestDto().getStudentId());
		assertEquals("message", response.getMessage());
		assertEquals("200 OK", response.getStatus());
	}
	
	@Test
	public void testDeleteStudentInfo() {
		StudentResponseDto studentResponseDto = getStudentResponseDto();
		when(studentServiceImpl.deleteStudentInfo(Mockito.anyLong())).thenReturn(studentResponseDto);
		StudentResponseDto response = studentContoller.deleteStudentInfo(1L);
		assertEquals(1, response.getStudentRequestDto().getStudentId());
		assertEquals("message", response.getMessage());
		assertEquals("200 OK", response.getStatus());
	}
	
	@Test
	public void testSaveStudentInfo() {
		StudentRequestDto studentRequestDto = getStudentRequestDto();
		StudentResponseDto studentResponseDto = getStudentResponseDto();
		when(studentServiceImpl.saveStudentinfo(studentRequestDto)).thenReturn(studentResponseDto);
		StudentResponseDto response = studentContoller.saveStudentInfo(studentRequestDto);
		assertEquals(1, response.getStudentRequestDto().getStudentId());
		assertEquals("message", response.getMessage());
		assertEquals("200 OK", response.getStatus());
	}
	
	@Test
	public void testUpdateStudentInfo() {
		StudentRequestDto studentRequestDto = getStudentRequestDto();
		StudentResponseDto studentResponseDto = getStudentResponseDto();
		when(studentServiceImpl.updateStudentInfo(1L,studentRequestDto)).thenReturn(studentResponseDto);
		StudentResponseDto response = studentContoller.updateStudentInfo(1L,studentRequestDto);
		assertEquals(1, response.getStudentRequestDto().getStudentId());
		assertEquals("message", response.getMessage());
		assertEquals("200 OK", response.getStatus());
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
	
	private StudentResponseDto getStudentResponseDto() {
		return new StudentResponseDto(getStudentRequestDto(),"message","200 OK");
	}
}
