package com.student.webservice.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "Address")	
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="addreddId")
public class AddressEntity {
	
	@Id
	@GeneratedValue
	private Long addreddId;

	private String addressType;

	private String village;

	private String town;

	private String district;

	private long pinCode;

	@ManyToOne(cascade=CascadeType.ALL,  fetch=FetchType.EAGER)
	@JoinColumn(name = "studentId", nullable = false)
	private StudentEntity studentEntity;

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

	public String getTown() {
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

	public StudentEntity getStudentEntity() {
		return studentEntity;
	}

	public void setStudentEntity(StudentEntity studentEntity) {
		this.studentEntity = studentEntity;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	
	@Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        AddressEntity addressEntity = (AddressEntity) o;
        return Objects.equals( addreddId, addressEntity.addreddId );
    }

    @Override
    public int hashCode() {
        return Objects.hash( addreddId );
    }

}
