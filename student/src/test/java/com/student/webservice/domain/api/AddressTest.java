package com.student.webservice.domain.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class AddressTest {
	@Test
	public void testAddressGettersSetters() {
		Address address = new Address();
		address.setAddressId(1L);
		address.setAddressType("Primary");
		address.setDistrict("district");
		address.setPinCode(11L);
		address.setStudent(new Student());
		address.setTown("town");
		address.setVillage("village");
		assertEquals(1L,address.getAddressId());
		assertEquals("Primary", address.getAddressType());
		assertEquals("district", address.getDistrict());
		assertEquals(11L, address.getPinCode());
		assertNotNull(address.getStudent());
	}

}
