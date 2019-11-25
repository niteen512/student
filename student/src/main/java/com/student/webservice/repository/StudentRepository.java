package com.student.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.student.webservice.entity.StudentEntity;
@Component
public interface StudentRepository extends JpaRepository<StudentEntity,Long>{ 	

}
