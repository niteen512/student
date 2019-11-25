package com.student.webservice.dto;

public class Address {

	private Long addreddId;

	private String addressType;

	private String village;

	private String town;

	private String district;

	private long pinCode;

	private StudentRequestDto student;

	public Long getAddressId() {
		return addreddId;
	}

	public void setAddressId(Long addreddId) {
		this.addreddId = addreddId;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTown(){
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	public StudentRequestDto getStudent() {
		return student;
	}

	public void setStudent(StudentRequestDto student) {
		this.student = student;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

}
