package com.cts.grizzlystore.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Login")
public class Login {
	@Id
	@Column
	private String userId;
	private String name;
	private String password;
	private String userType;
	private String address;
	private String designation;
	private int userStatus;
	private int contactNumber;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Login(String userId, String name, String password, String userType, String address, String designation,
			int userStatus, int contactNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.userType = userType;
		this.address = address;
		this.designation = designation;
		this.userStatus = userStatus;
		this.contactNumber = contactNumber;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	
}
