package com.student.webservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.webservice.entity.AddressEntity;
import com.student.webservice.entity.StudentDao;
import com.student.webservice.entity.StudentEntity;

@Component
public class StudentDaoImpl implements StudentDao {


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
			if(studentRepository.findById(studentId).isPresent()) {
				// here while updating student information I am getting exception multiple
				// representations of same entity are being merged i.e managed and detached.
				// I dont get this exception if i call save directly without calling findById
				// so if i create one separate AddressRepository for saving addressEntity only,
				// again when i will call findById for addressEntity to check if that entity
				// already exists in database,
				// i will eventually get same exception
				// i tried flush after findById to check if it cold help,then I am getting
				// exception multiple representations of same entity are being merged i.e
				// detached and detached.
				//currently looking into it...
				return studentRepository.save(studentEntity);
			}
			
		} catch (Exception exception) {
			LoggerFactory.getLogger(StudentDaoImpl.class).info("Exception while updating student info with student ID" + studentEntity.getStudentId(),
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
