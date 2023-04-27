package com.rsn.mark1.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Employee_Record_Data")
@Builder
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Employee_Id")
	private int id;

	//@Column(name = "Employee_First_Name")
	private String firstName;

	//@Column(name = "Employee_Last_Name")
	private String lastName;

	//@Column(name = "Employee_Email-Id")
	private String email;

	//@Column(name = "Employee_emailid_password")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee(int id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
