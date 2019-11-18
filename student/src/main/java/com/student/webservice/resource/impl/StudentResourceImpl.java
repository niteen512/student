package com.student.webservice.resource.impl;

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

import com.student.webservice.domain.api.Student;
import com.student.webservice.domain.impl.StudentServiceImpl;

@RestController
public class StudentResourceImpl {

	@Autowired
	StudentServiceImpl studentServiceImpl;

	@PostMapping("/student")
	@Consumes(MediaType.APPLICATION_JSON)
	public Student saveStudentInfo(@RequestBody Student student) {
		return studentServiceImpl.saveStudentinfo(student);
	}

	@GetMapping("/student/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@ResponseBody
	public Student getStudentInfo(@PathVariable(value = "studentId") Long studentId) {
		return studentServiceImpl.retrieveStudentInfo(studentId);
	}

	@PutMapping("/student/{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Student updateStudentInfo(@PathVariable(value = "studentId") Long studentId,@RequestBody Student student) {
		return studentServiceImpl.updateStudentInfo(studentId,student);
	}

	@DeleteMapping("/student/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@ResponseBody
	public void deleteStudentInfo(@PathVariable(value = "studentId") Long studentId) {
		studentServiceImpl.deleteStudentInfo(studentId);

	}

}
