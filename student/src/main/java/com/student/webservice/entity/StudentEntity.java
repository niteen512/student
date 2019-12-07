package com.student.webservice.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name = "student_details")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="studentId")
public class StudentEntity { 
	@Id
    private Long studentId;
	
    private String firstName;

    private String lastName;

    private long marks;
    
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "studentEntity"/* ,orphanRemoval=true */)
    private List<AddressEntity> addressEntityList; 

    

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMarks() {
		return marks;
	}

	public void setMarks(long marks) {
		this.marks = marks;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public List<AddressEntity> getAddressEntityList() {
		return addressEntityList;
	}

	public void setAddressEntityList(List<AddressEntity> addressEntityList) {
		this.addressEntityList = addressEntityList;
	}

	
	
	@Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        StudentEntity studentEntity = (StudentEntity) o;
        return Objects.equals( studentId, studentEntity.studentId );
    }

    @Override
    public int hashCode() {
        return Objects.hash( studentId );
    }

}
