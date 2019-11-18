package com.student.webservice.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.webservice.dao.api.StudentEntity;
import com.student.webservice.dao.impl.StudentDaoImpl;
import com.student.webservice.domain.api.Student;
import com.student.webservice.domain.api.StudentService;
import com.student.webservice.helper.impl.RequestMapperHelperImpl;
import com.student.webservice.helper.impl.ResponseMapperHelperImpl;

@Component
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDaoImpl studentDaoImpl;

	@Autowired
	RequestMapperHelperImpl requestMapperHelperImpl;

	@Autowired
	ResponseMapperHelperImpl responseMapperHelperImpl;

	public Student retrieveStudentInfo(Long studentId) {
		StudentEntity studentEntity = studentDaoImpl.retrieveStudentInfo(studentId);
		return requestMapperHelperImpl.mapStudentEntityToStudent(studentEntity); 
	}

	public Student saveStudentinfo(Student student) {
		StudentEntity studentEntity = responseMapperHelperImpl.mapStudentToStudentEntity(student);
		StudentEntity studentEntityReturned =studentDaoImpl.saveStudentInfo(studentEntity);
		return requestMapperHelperImpl.mapStudentEntityToStudent(studentEntityReturned);
		
	}

	public void deleteStudentInfo(Long studentId) {
		studentDaoImpl.deleteStudentInfo(studentId);
	}

	public Student updateStudentInfo(Long studentId, Student student) {
		StudentEntity studentEntity =
				  responseMapperHelperImpl.mapStudentToStudentEntity(student);
		StudentEntity studentEntityReturned = studentDaoImpl.updateStudentInfo(studentEntity, studentId);
		return requestMapperHelperImpl.mapStudentEntityToStudent(studentEntityReturned);
		/*
		 * StudentEntity studentEntity = studentDaoImpl.retrieveStudentInfo(studentId);
		 * StudentEntity studentEntityNew =
		 * responseMapperHelperImpl.mapStudentToStudentEntity(student); StudentEntity
		 * updatedStudentEntity studentEntity =
		 * responseMapperHelperImpl.mapStudentEntityToStudentEntity(studentEntity,
		 * studentEntityNew); studentDaoImpl.saveStudentInfo(studentEntity);
		 */
	}

}
