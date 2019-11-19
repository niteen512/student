package com.student.webservice.helper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.student.webservice.dao.api.AddressEntity;
import com.student.webservice.dao.api.StudentEntity;
@Component
public class UpdateMapperHelperImpl {
	public StudentEntity check(StudentEntity entity,StudentEntity studentEntity) {
		if(entity==null) {
			entity=studentEntity;
			return entity;
		}
		else {
			entity.setFirstName(studentEntity.getFirstName());
			entity.setLastName(studentEntity.getLastName());
			entity.setMarks(studentEntity.getMarks());
			List<AddressEntity> entityAddress = new ArrayList<>();
			boolean flag=true;
			for(AddressEntity sEntity : studentEntity.getAddressEntityList()) {
				flag=true;
				for(AddressEntity eEntity : entity.getAddressEntityList()) {
					if(sEntity.getAddressId()==eEntity.getAddressId()) {
						eEntity.setAddressType(sEntity.getAddressType());
						eEntity.setDistrict(sEntity.getDistrict());
						eEntity.setPinCode(sEntity.getPinCode());
						eEntity.setTown(sEntity.getTown());
						eEntity.setVillage(sEntity.getVillage());
						flag=false;
						break;
					}
					
				}
				if(flag==true) {
					entityAddress.add(sEntity);
				}
			}
			entity.getAddressEntityList().addAll(entityAddress);
		}
		return entity;
	}


}
