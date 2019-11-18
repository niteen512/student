package com.student.webservice.dao.api;

public interface StudentDao {

	public StudentEntity retrieveStudentInfo(Long studentId);
	public StudentEntity saveStudentInfo(StudentEntity studentEntity) ;
	public StudentEntity updateStudentInfo(StudentEntity studentEntity,Long studentId);
	public void deleteStudentInfo(Long studentId);
}
