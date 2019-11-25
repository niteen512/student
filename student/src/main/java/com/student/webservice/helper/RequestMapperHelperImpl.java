package com.student.webservice.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.student.webservice.dto.Address;
import com.student.webservice.dto.StudentRequestDto;
import com.student.webservice.entity.AddressEntity;
import com.student.webservice.entity.StudentEntity;

@Component
public class RequestMapperHelperImpl {
	
	

	public StudentRequestDto mapStudentEntityToStudentResponseDto(StudentEntity studentEntity) {
		StudentRequestDto student=new StudentRequestDto();
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
