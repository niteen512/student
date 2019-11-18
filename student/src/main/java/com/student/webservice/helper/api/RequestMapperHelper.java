package com.student.webservice.helper.api;

import com.student.webservice.dao.api.StudentEntity;
import com.student.webservice.domain.api.Student;

public interface RequestMapperHelper {
	public Student mapStudentEntityToStudent(StudentEntity studentEntity);
}
