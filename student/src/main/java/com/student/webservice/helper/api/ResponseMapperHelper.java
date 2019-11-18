package com.student.webservice.helper.api;

import com.student.webservice.dao.api.StudentEntity;
import com.student.webservice.domain.api.Student;

public interface ResponseMapperHelper {
	public StudentEntity mapStudentToStudentEntity(Student student);
	public StudentEntity mapStudentEntityToStudentEntity(StudentEntity studentEntity,StudentEntity studentEntityNew);

}
