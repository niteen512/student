package com.student.webservice.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
		assertEquals(1L, addressEntity.getAddressId());
		assertEquals("Primary", addressEntity.getAddressType());
		assertEquals("district", addressEntity.getDistrict());
		assertEquals(11L, addressEntity.getPinCode());
		assertNotNull(addressEntity.getStudentEntity());
		assertEquals("village", addressEntity.getVillage());
		assertEquals("town",addressEntity.getTown());
	}

	@Test
	public void testHashCode() {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddressId(1L);
		assertNotNull(addressEntity.hashCode());
	}

	@Test
	public void testEquals() {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddressId(1L);

		AddressEntity addressEntity1 = addressEntity;
		assertTrue(addressEntity.equals(addressEntity1));

	}
	@Test
	public void testEqualsWhenContentsEqualWhenSameObject() {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddressId(1L);

		AddressEntity addressEntity1 = new AddressEntity();
		addressEntity1.setAddressId(1L);
		assertTrue(addressEntity.equals(addressEntity1));

	}

	@Test
	public void testEqualsNull() {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddressId(1L);

		AddressEntity addressEntity1 = null;
		assertFalse(addressEntity.equals(addressEntity1));

	}

	@Test
	public void testEqualsObject() {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddressId(1L);
		Object o = new Object();
		assertFalse(addressEntity.equals(o));

	}

}
