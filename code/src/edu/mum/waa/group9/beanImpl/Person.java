package edu.mum.waa.group9.beanImpl;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import edu.mum.waa.group9.beanInterfaces.PersonInterface;

@Named("person")
@SessionScoped
public class Person implements PersonInterface, Serializable {
	private static final long serialVersionUID = -3444844973409580862L;
	
	private int id;
	private String firstName;
	private String lastName;
	private String sex;
	private String phone;
	private String email;
	private String password;

	private PersonAddress address;
	private Blob photo;
	private boolean registered = false;

	private List<Ride> offerredRidesList = new ArrayList<Ride>();
	
	
	public String holder(){
		return null;
	}

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

	public void handleFileUpload() {

	}

	public int getAge() {
		return 100;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public List<Ride> getOfferredRidesList() {
		return offerredRidesList;
	}

	public void setOfferredRidesList(List<Ride> offerredRidesList) {
		this.offerredRidesList = offerredRidesList;
	}
}
