package com.student.webservice.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.student.webservice.dto.Address;
import com.student.webservice.dto.StudentRequestDto;
import com.student.webservice.entity.AddressEntity;
import com.student.webservice.entity.StudentEntity;
@Component
public class ResponseMapperHelperImpl {

	public StudentEntity mapStudentToStudentEntity(StudentRequestDto student) {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStudentId(student.getStudentId());
		studentEntity.setFirstName(student.getFirstName());
		studentEntity.setLastName(student.getLastName());
		studentEntity.setMarks(student.getMarks());
		List<AddressEntity> addressEntityList=new ArrayList<>();
		List<Address> addressList = student.getAddressList();
		for(Address address : addressList) {
			AddressEntity addressEntity = new AddressEntity();
			addressEntity.setAddressId(address.getAddressId());
			addressEntity.setAddressType(address.getAddressType());
			addressEntity.setVillage(address.getVillage());
			addressEntity.setTown(address.getTown());
			addressEntity.setDistrict(address.getDistrict());
			addressEntity.setPinCode(address.getPinCode());
			addressEntity.setStudentEntity(studentEntity);
			addressEntityList.add(addressEntity);
		}
		studentEntity.setAddressEntityList(addressEntityList);
		
		return studentEntity;
	}
	
	public StudentEntity mapStudentEntityToStudentEntity(StudentEntity studentEntity,StudentEntity studentEntityNew) {
		studentEntity.setStudentId(studentEntityNew.getStudentId());
		studentEntity.setFirstName(studentEntityNew.getFirstName());
		studentEntity.setLastName(studentEntityNew.getLastName());
		studentEntity.setMarks(studentEntityNew.getMarks());
		studentEntity.setAddressEntityList(studentEntityNew.getAddressEntityList());
		return studentEntity;
	}

}
