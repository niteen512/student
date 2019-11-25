package com.student.webservice.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.webservice.dto.StudentRequestDto;
import com.student.webservice.dto.StudentResponseDto;
import com.student.webservice.dto.StudentServiceImpl;

@RestController
public class StudentContoller {

	@Autowired
	StudentServiceImpl studentServiceImpl;

	@PostMapping("/student")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public StudentResponseDto saveStudentInfo(@RequestBody StudentRequestDto student) {
		return studentServiceImpl.saveStudentinfo(student);
	}

	@GetMapping("/student/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@ResponseBody
	public StudentResponseDto getStudentInfo(@PathVariable(value = "studentId") Long studentId) {
		return studentServiceImpl.retrieveStudentInfo(studentId);
	}

	@PutMapping("/student/{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public StudentResponseDto updateStudentInfo(@PathVariable(value = "studentId") Long studentId,@RequestBody StudentRequestDto student) {
		return studentServiceImpl.updateStudentInfo(studentId,student);
	}

	@DeleteMapping("/student/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@ResponseBody
	public StudentResponseDto deleteStudentInfo(@PathVariable(value = "studentId") Long studentId) {
		return studentServiceImpl.deleteStudentInfo(studentId);

	}

}
