package edu.mum.waa.group9.beanImpl;

import java.io.Serializable;
import java.sql.Blob;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("person")
@SessionScoped
public class Person implements Serializable{

	private int id;
	private String firstName;
	private String lastName;
	private String sex;
	private String phone;
	private String email;
	private String password;
	private String confirmPassword;
	private PersonAddress address;
	private Blob photo;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public PersonAddress getAddress() {
		return address;
	}

	public void setAddress(PersonAddress address) {
		this.address = address;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	
	public void handleFileUpload(){
		
	}
	
	public int getAge(){
		return 100;
	}
	
	public String getFullName(){
		return firstName+" "+lastName;
	}
}
