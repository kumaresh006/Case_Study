package com.bean;


public class Operator
{
	private String firstName;
	private String lastName;
	private String emailId;
	private String phoneNumber;
	private int shiftTimeStart;
	private int shiftTimeEnd;
	private int maxCustomer;
	private String creationDate;
	
	public Operator(String firstName, String lastName, String emailId, String phoneNumber, int shiftTimeStart, int shiftTimeEnd, int maxCustomer, String creationDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.shiftTimeStart = shiftTimeStart;
		this.shiftTimeEnd = shiftTimeEnd;
		this.maxCustomer = maxCustomer;
		this.creationDate = creationDate;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getShiftTimeStart() {
		return shiftTimeStart;
	}

	public void setShiftTimeStart(int shiftTimeStart) {
		this.shiftTimeStart = shiftTimeStart;
	}

	public int getShiftTimeEnd() {
		return shiftTimeEnd;
	}

	public void setShiftTimeEnd(int shiftTimeEnd) {
		this.shiftTimeEnd = shiftTimeEnd;
	}

	public int getMaxCustomer() {
		return maxCustomer;
	}

	public void setMaxCustomer(int maxCustomer) {
		this.maxCustomer = maxCustomer;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
}
