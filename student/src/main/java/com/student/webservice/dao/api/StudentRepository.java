package com.student.webservice.dao.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
@Component
public interface StudentRepository extends CrudRepository<StudentEntity,Long>{ 	

}
