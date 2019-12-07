package com.student.webservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class AddressEntityTest {
	@Test
	public void testAddressEntityGettersSetters() {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddressId(1L);
		addressEntity.setAddressType("Primary");
		addressEntity.setDistrict("district");
		addressEntity.setPinCode(11L);
		addressEntity.setStudentEntity(new StudentEntity());
		addressEntity.setTown("town");
		addressEntity.setVillage("village");
		assertEquals(1L,addressEntity.getAddressId());
		assertEquals("Primary", addressEntity.getAddressType());
		assertEquals("district", addressEntity.getDistrict());
		assertEquals(11L, addressEntity.getPinCode());
		assertNotNull(addressEntity.getStudentEntity());
	}

}
