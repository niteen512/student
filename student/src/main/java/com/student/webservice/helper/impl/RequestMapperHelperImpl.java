package com.student.webservice.helper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.student.webservice.dao.api.AddressEntity;
import com.student.webservice.dao.api.StudentEntity;
import com.student.webservice.domain.api.Address;
import com.student.webservice.domain.api.Student;
import com.student.webservice.helper.api.RequestMapperHelper;

@Component
public class RequestMapperHelperImpl implements RequestMapperHelper{
	
	

	public Student mapStudentEntityToStudent(StudentEntity studentEntity) {
		Student student=new Student();
		student.setStudentId(studentEntity.getStudentId());
		student.setFirstName(studentEntity.getFirstName());
		student.setLastName(studentEntity.getLastName());
		student.setMarks(studentEntity.getMarks());
		List<Address> addressList=new ArrayList<>();
		List<AddressEntity> addressEntityList = studentEntity.getAddressEntityList();
		for(AddressEntity addressEntity : addressEntityList) {
			Address address = new Address();
			address.setAddressId(addressEntity.getAddressId());
			address.setAddressType(addressEntity.getAddressType());
			address.setVillage(addressEntity.getVillage());
			address.setTown(addressEntity.getTown());
			address.setDistrict(addressEntity.getDistrict());
			address.setPinCode(addressEntity.getPinCode());
			addressList.add(address);
		}
		student.setAddressList(addressList);
		return student;
	}
	
	
	

}
