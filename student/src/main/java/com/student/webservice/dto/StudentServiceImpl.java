package com.student.webservice.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.student.webservice.entity.StudentEntity;
import com.student.webservice.helper.RequestMapperHelperImpl;
import com.student.webservice.helper.ResponseMapperHelperImpl;
import com.student.webservice.helper.UpdateMapperHelperImpl;
import com.student.webservice.repository.StudentDaoImpl;

@Component
public class StudentServiceImpl {

	@Autowired
	StudentDaoImpl studentDaoImpl;

	@Autowired
	UpdateMapperHelperImpl updateMapperHelperImpl;

	@Autowired
	RequestMapperHelperImpl requestMapperHelperImpl;

	@Autowired
	ResponseMapperHelperImpl responseMapperHelperImpl;

	public StudentResponseDto retrieveStudentInfo(Long studentId) {
		StudentEntity studentEntity = studentDaoImpl.retrieveStudentInfo(studentId);
		if(studentEntity==null) {
			return new StudentResponseDto(null,"Student Infomation not found for student with ID"+studentId,null);
		}
		return new StudentResponseDto(requestMapperHelperImpl.mapStudentEntityToStudentResponseDto(studentEntity),"Student Infomation Retrieved Successfully",HttpStatus.OK.toString());
	}

	public StudentResponseDto saveStudentinfo(StudentRequestDto student) {
		StudentEntity studentEntity = responseMapperHelperImpl.mapStudentToStudentEntity(student);
		studentEntity = studentDaoImpl.saveStudentInfo(studentEntity);
		return new StudentResponseDto(requestMapperHelperImpl.mapStudentEntityToStudentResponseDto(studentEntity),"Student Infomation Saved Successfully",HttpStatus.OK.toString());
	}

	public StudentResponseDto deleteStudentInfo(Long studentId) {
		StudentEntity studentEntity = studentDaoImpl.deleteStudentInfo(studentId);
		if(studentEntity==null) {
			return new StudentResponseDto(null,"No Student Infomation present with ID"+studentId,null);
		}
		return new StudentResponseDto(requestMapperHelperImpl.mapStudentEntityToStudentResponseDto(studentEntity),"Student Infomation Deleted Successfully for student with ID:"+studentId,HttpStatus.OK.toString());
	}

	public StudentResponseDto updateStudentInfo(Long studentId, StudentRequestDto student) {
		StudentEntity studentEntity = responseMapperHelperImpl.mapStudentToStudentEntity(student);
		studentEntity = studentDaoImpl.updateStudentInfo(studentEntity, studentId);
		if(studentEntity==null) {
			return new StudentResponseDto(null,"No Student Infomation present with ID"+studentId,null);
		}
		return new StudentResponseDto(requestMapperHelperImpl.mapStudentEntityToStudentResponseDto(studentEntity),"Student Infomation Updated Successfully",HttpStatus.OK.toString());

	}

}
