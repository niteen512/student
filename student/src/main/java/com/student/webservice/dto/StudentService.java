package com.student.webservice.domain.api;

public interface StudentService {
	public Student retrieveStudentInfo(Long studentId);
	public Student saveStudentinfo(Student student);
	public void deleteStudentInfo(Long studentId);
	public Student updateStudentInfo(Long studentId, Student student);

}
