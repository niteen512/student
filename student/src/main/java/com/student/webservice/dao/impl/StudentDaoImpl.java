package com.student.webservice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.webservice.dao.api.AddressEntity;
import com.student.webservice.dao.api.StudentDao;
import com.student.webservice.dao.api.StudentEntity;
import com.student.webservice.dao.api.StudentRepository;

@Component
public class StudentDaoImpl implements StudentDao {

	/*
	 * @Autowired LoggerFactory logger;
	 */

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

	public StudentEntity updateStudentInfo(StudentEntity studentEntity,Long studentId) {
		try {
			StudentEntity entity = (StudentEntity)studentRepository.findById(studentId).orElseThrow();
			
			studentRepository.deleteById(studentId);
			return studentRepository.save(studentEntity);
		} catch (Exception exception) {
			LoggerFactory.getLogger(StudentDaoImpl.class).info("Exception while updating student info with student ID" + studentEntity.getStudentId(),
					exception);
		}
		return null;

	}

	
	public void deleteStudentInfo(Long studentId) {
		try {
			studentRepository.deleteById(studentId);
		} catch (Exception exception) {
			LoggerFactory.getLogger(StudentDaoImpl.class).info("Exception while saving student info with student ID" +studentId ,
					exception);
		}

	}
	
}
