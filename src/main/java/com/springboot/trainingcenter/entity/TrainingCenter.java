package com.springboot.trainingcenter.entity;

import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
 * Entity is used to map our class to relational database as tables
 * Id: It is used to declare Primary Key
 * Generated Value: it will automatically generates the Id value
 * Getter is used for helps to access the attributes from a class
 * Setter is used for helps to set the value to attributes in a class
 * NoArgsConstructor is a default constructor
 * OneToOne used to associate one java object to another java object.(one row of particular
 *  table related to another table)
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class TrainingCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	// Name of the training center
	@Column(length = 40,nullable = false)
	String centerName;
	
	// Code assigned to the training center
	@Column(length = 12,nullable = false)
	@Size(max=12)
	String centerCode;
	
	// Address of the training center
	@OneToOne(targetEntity = Address.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "Address_id",referencedColumnName = "addressId")
	Address address;
	
	// List of course names offered by the training center
	@ElementCollection
	List<String> courseNames;
	
	// Maximum capacity of students that the training center can accommodate
	long studentCapacity;
	// Date when the training center was created
	Date createdOn;
	// Email address of the training center
	@Email
	String email;
	// Phone number of the training center
	@Size(max = 10)
	String phone;
	
	public TrainingCenter(String centerName, String centerCode, Address address, List<String> courseNames,
			long studentCapacity, Date createdOn, String email, String phone) {
		// Parameterized constructor to initialize a TrainingCenter object
		this.centerName = centerName;
		this.centerCode = centerCode;
		this.address = address;
		this.courseNames = courseNames;
		this.studentCapacity = studentCapacity;
		this.createdOn = createdOn;
		this.email = email;
		this.phone = phone;
	}
}
