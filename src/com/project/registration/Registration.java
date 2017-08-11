package com.project.registration;

import java.sql.Date;

public class Registration {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	private String mobile;
	private String gender;
	private String newpassword;

	public Registration() {

	}

	public Registration(String firstName, String lastname, String email, String password, String confirmPassword,
			String mobile, String gender ,String newpassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastname;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.mobile = mobile;
		this.gender = gender;
		this.newpassword =newpassword;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
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
	public String getConfirmpassword()
	{
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword=confirmPassword;
	}
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile=mobile;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender){
		this.gender=gender;
	}

@Override
	public String toString(){
	
	//String answer = "Got you";
	//return answer;
	return "Registration [FirstName=" + firstName + ",LastName=" + lastName +",Email=" + email +",Password=" + password + ",ConfirmPassword=" + confirmPassword +",Mobile=" + mobile + ",Gender=" + gender +")";
	}
}
