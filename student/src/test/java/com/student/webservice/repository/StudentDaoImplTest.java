package com.student.webservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
		StudentEntity studentEntity = getStudentEntity();
		when(studentRepository.findById(1L)).thenReturn(Optional.of(studentEntity));
		studentDaoImpl.retrieveStudentInfo(1L);
	}
	
	@Test
	public void testRetrieveStudentInfoException() {
		when(studentRepository.findById(1L)).thenThrow(RuntimeException.class);
		assertThrows(RuntimeException.class, ()->{studentRepository.findById(1L);});
		studentDaoImpl.retrieveStudentInfo(1L);
		
	}
	
	@Test
	public void testSaveStudentInfo() {
		StudentEntity studentEntity = getStudentEntity();
		when(studentRepository.save(studentEntity)).thenReturn(studentEntity);
		studentDaoImpl.saveStudentInfo(studentEntity);
		assertEquals(1L,studentEntity.getStudentId());
		
	}
	@Test
	public void testSaveStudentInfoReturnsException() {
		StudentEntity studentEntity = getStudentEntity();
		when(studentRepository.save(studentEntity)).thenThrow(RuntimeException.class);
		assertThrows(RuntimeException.class, ()->{studentRepository.save(studentEntity);});
		studentDaoImpl.saveStudentInfo(studentEntity);
		
	}
	
	@Test
	public void testDeleteStudentInfo() {
		StudentEntity studentEntity = getStudentEntity();
		when(studentRepository.findById(1L)).thenReturn(Optional.of(studentEntity));
		studentDaoImpl.deleteStudentInfo(1L);
	}
	
	@Test
	public void testDeleteStudentInfoRecordNotPresent() {
		when(studentRepository.findById(1L)).thenReturn(Optional.empty());
		studentDaoImpl.deleteStudentInfo(1L);
	}
	
	@Test
	public void testDeleteStudentInfoException() {
		when(studentRepository.findById(1L)).thenThrow(RuntimeException.class);
		assertThrows(RuntimeException.class, ()->{studentRepository.findById(1L);});
		studentDaoImpl.deleteStudentInfo(1L);
		
	}
	
	private StudentEntity getStudentEntity() {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStudentId(1L);
		return studentEntity;
	}
	
	
	
}
