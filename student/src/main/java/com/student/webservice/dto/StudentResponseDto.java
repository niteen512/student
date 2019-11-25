package com.student.webservice.dto;

public class StudentResponseDto {

	StudentRequestDto studentRequestDto;
	
	String message;
	
	public StudentResponseDto(StudentRequestDto studentRequestDto, String message, String status) {
		super();
		this.studentRequestDto = studentRequestDto;
		this.message = message;
		this.status = status;
	}

	String status;

	public StudentRequestDto getStudentRequestDto() {
		return studentRequestDto;
	}

	public void setStudentRequestDto(StudentRequestDto studentRequestDto) {
		this.studentRequestDto = studentRequestDto;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
