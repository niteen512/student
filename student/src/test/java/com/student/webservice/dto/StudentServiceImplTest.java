package com.student.webservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.student.webservice.entity.StudentEntity;
import com.student.webservice.helper.RequestMapperHelperImpl;
import com.student.webservice.helper.ResponseMapperHelperImpl;
import com.student.webservice.helper.UpdateMapperHelperImpl;
import com.student.webservice.repository.StudentDaoImpl;

public class StudentServiceImplTest {
	
	@Mock
	StudentDaoImpl studentDaoImpl;

	@Mock
	UpdateMapperHelperImpl updateMapperHelperImpl;

	@Mock
	RequestMapperHelperImpl requestMapperHelperImpl;

	@Mock
	ResponseMapperHelperImpl responseMapperHelperImpl;
	
	@InjectMocks
	StudentServiceImpl studentServiceImpl;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRetrieveStudentInfo() {
		StudentEntity studentEntity = getStudentEntity();
		when(studentDaoImpl.retrieveStudentInfo(Mockito.anyLong())).thenReturn(studentEntity);
		when(requestMapperHelperImpl.mapStudentEntityToStudentResponseDto(studentEntity)).thenReturn(new StudentRequestDto());
		assertEquals("200 OK", studentServiceImpl.retrieveStudentInfo(1L).status);
		studentServiceImpl.retrieveStudentInfo(1L);
	}
	
	@Test
	public void testRetrieveStudentInfoNull() {
		when(studentDaoImpl.retrieveStudentInfo(Mockito.anyLong())).thenReturn(null);
		assertEquals("Student Infomation not found for student with ID: 1", studentServiceImpl.retrieveStudentInfo(1L).message);
		studentServiceImpl.retrieveStudentInfo(1L);
	}
	@Test
	public void testSaveStudentinfo() {
		StudentEntity studentEntity = getStudentEntity();
		StudentRequestDto studentRequestDto = getStudentRequestDto();
		when(responseMapperHelperImpl.mapStudentToStudentEntity(studentRequestDto)).thenReturn(studentEntity);
		when(studentDaoImpl.saveStudentInfo(studentEntity)).thenReturn(studentEntity);
		when(requestMapperHelperImpl.mapStudentEntityToStudentResponseDto(studentEntity)).thenReturn(studentRequestDto);
		assertEquals("200 OK", studentServiceImpl.saveStudentinfo(studentRequestDto).status);
	}
	
	@Test
	public void testDeleteStudentInfo() {
		StudentEntity studentEntity = getStudentEntity();
		when(studentDaoImpl.deleteStudentInfo(Mockito.anyLong())).thenReturn(studentEntity);
		when(requestMapperHelperImpl.mapStudentEntityToStudentResponseDto(studentEntity)).thenReturn(getStudentRequestDto());
		assertEquals("200 OK", studentServiceImpl.deleteStudentInfo(Mockito.anyLong()).status);
	}
	
	@Test
	public void testDeleteStudentInfoNull() {
		when(studentDaoImpl.deleteStudentInfo(Mockito.anyLong())).thenReturn(null);
		assertEquals("No Student Infomation present with ID: 1", studentServiceImpl.deleteStudentInfo(1L).message);
	}
	
	@Test
	public void testUpdateStudentInfo(){
		StudentEntity studentEntity = getStudentEntity();
		StudentRequestDto studentRequestDto = getStudentRequestDto();
		when(responseMapperHelperImpl.mapStudentToStudentEntity(studentRequestDto)).thenReturn(studentEntity);
		when(studentDaoImpl.retrieveStudentInfo(Mockito.anyLong())).thenReturn(studentEntity);
		when(updateMapperHelperImpl.mergeExistingAndNew(studentEntity,studentEntity)).thenReturn(studentEntity);
		when(studentDaoImpl.saveStudentInfo(studentEntity)).thenReturn(studentEntity);
		when(requestMapperHelperImpl.mapStudentEntityToStudentResponseDto(studentEntity)).thenReturn(studentRequestDto);
		assertEquals("200 OK", studentServiceImpl.updateStudentInfo(1L,studentRequestDto).status);
	}
	
	@Test
	public void testUpdateStudentInfoNull(){
		StudentEntity studentEntity = getStudentEntity();
		StudentRequestDto studentRequestDto = getStudentRequestDto();
		when(responseMapperHelperImpl.mapStudentToStudentEntity(studentRequestDto)).thenReturn(studentEntity);
		when(studentDaoImpl.retrieveStudentInfo(Mockito.anyLong())).thenReturn(studentEntity);
		when(updateMapperHelperImpl.mergeExistingAndNew(studentEntity,studentEntity)).thenReturn(studentEntity);
		when(studentDaoImpl.saveStudentInfo(studentEntity)).thenReturn(null);
		assertEquals("No Student Infomation present with ID: 1", studentServiceImpl.updateStudentInfo(1L,studentRequestDto).message);
	}
	
	
	
	private StudentEntity getStudentEntity() {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStudentId(1L);
		return studentEntity;
	}
	
	private StudentRequestDto getStudentRequestDto() {
		StudentRequestDto studentRequestDto = new StudentRequestDto();
		studentRequestDto.setStudentId(1L);
		return studentRequestDto;
	}
}
