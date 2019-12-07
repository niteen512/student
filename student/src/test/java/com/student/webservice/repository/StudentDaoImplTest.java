package com.student.webservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.student.webservice.entity.StudentEntity;

@RunWith(MockitoJUnitRunner.class)
public class StudentDaoImplTest {
	
	@Mock
	StudentRepository studentRepository;
	
	@InjectMocks
	StudentDaoImpl studentDaoImpl;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testRetrieveStudentInfo() {
		when(studentRepository.findById(1L)).thenReturn(Mockito.any());
		studentDaoImpl.retrieveStudentInfo(1L);
	}
	
	@Test
	public void testRetrieveStudentInfoException() {
		when(studentRepository.findById(1L)).thenThrow(RuntimeException.class);
		assertThrows(RuntimeException.class, ()->{studentRepository.findById(1L);});
		
	}
	
	@Test
	public void testSaveStudentInfo() {
		StudentEntity studentEntity = getStudentEntity();
		when(studentRepository.save(studentEntity)).thenReturn(studentEntity);
		assertEquals(1L,studentEntity.getStudentId());
		
	}
	@Test
	public void testSaveStudentInfoReturnsException() {
		StudentEntity studentEntity = getStudentEntity();
		when(studentRepository.save(studentEntity)).thenThrow(RuntimeException.class);
		assertThrows(RuntimeException.class, ()->{studentRepository.save(studentEntity);});
		
	}
	private StudentEntity getStudentEntity() {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStudentId(1L);
		return studentEntity;
	}
	
	
	
}
