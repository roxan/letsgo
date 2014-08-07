package edu.mum.waa.group9.beanImpl;

public class Person {
	
	private int id;
	private String firstName;
	private String lastName;
	private String sex;
	private String email;
	private String password;
	private PersonAddress address;
	
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
	public PersonAddress getAddress() {
		return address;
	}
	public void setAddress(PersonAddress address) {
		this.address = address;
	}
}
