package com.student.webservice.repository;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.webservice.entity.StudentEntity;

@Component
public class StudentDaoImpl {


	@Autowired
	StudentRepository studentRepository;

	public StudentEntity retrieveStudentInfo(Long studentId) {
		try {
			StudentEntity studentEntity = studentRepository.findById(studentId).get();
			return studentEntity;
		} catch (Exception exception) {
			LoggerFactory.getLogger(StudentDaoImpl.class).info("Exception while retrieving student info with student ID" + studentId, exception);
		}
		return new StudentEntity();
	}

	public StudentEntity saveStudentInfo(StudentEntity studentEntity) {
		try {
			return studentRepository.save(studentEntity);
		} catch (Exception exception) {
			LoggerFactory.getLogger(StudentDaoImpl.class).info("Exception while saving student info with student ID" + studentEntity.getStudentId(),
					exception);
		}
		return null;

	}

	
	public StudentEntity deleteStudentInfo(Long studentId) {
		try {
			Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
			if(studentEntity.isPresent()) {
			studentRepository.deleteById(studentId);
			return studentEntity.get();
			}
		} catch (Exception exception) {
			LoggerFactory.getLogger(StudentDaoImpl.class).info("Exception while saving student info with student ID" +studentId ,
					exception);
		}
		return null;

	}
	
}
