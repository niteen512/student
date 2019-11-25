package com.student.webservice.entity;

public interface StudentDao {

	public StudentEntity retrieveStudentInfo(Long studentId);
	public StudentEntity saveStudentInfo(StudentEntity studentEntity) ;
	public StudentEntity updateStudentInfo(StudentEntity studentEntity,Long studentId);
	public StudentEntity deleteStudentInfo(Long studentId);
}
