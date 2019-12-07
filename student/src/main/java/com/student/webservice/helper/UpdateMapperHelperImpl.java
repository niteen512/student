package com.student.webservice.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.student.webservice.entity.AddressEntity;
import com.student.webservice.entity.StudentEntity;
@Component
public class UpdateMapperHelperImpl {
	public StudentEntity mergeExistingAndNew(StudentEntity entity,StudentEntity studentEntity) {
		if(entity==null) {
			return studentEntity;
		}
		else {
			List<AddressEntity> entityAddress = new ArrayList<>();
			boolean flag=true;
			for(AddressEntity aEntity : entity.getAddressEntityList()) {
				flag=true;
				for(AddressEntity aStudentEntity : studentEntity.getAddressEntityList()) {
					if(aStudentEntity.getAddressId()==aEntity.getAddressId()) {
						flag=false;
						break;
					}
					
				}
				if(flag==true) {
					entityAddress.add(aEntity);
				}
			}
			studentEntity.getAddressEntityList().addAll(entityAddress);
		}
		return studentEntity;
	}


}
