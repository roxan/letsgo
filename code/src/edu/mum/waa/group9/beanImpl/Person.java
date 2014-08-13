package edu.mum.waa.group9.beanImpl;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import edu.mum.waa.group9.beanInterfaces.PersonInterface;

@Named("person")
@SessionScoped
public class Person implements PersonInterface, Serializable {

	private static final long serialVersionUID = -6282590215501200447L;

	private int id;
	private String firstName;
	private String lastName;
	private String sex;
	private String phone;
	private String email;
	private String password;
	private String confirmPassword;
	private PersonAddress address;
	private StreamedContent photo;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	private boolean registered = false;

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

	public StreamedContent getPhoto() {
		if (null != photo) {
			return photo;
		} else {
			ExternalContext externalContext = FacesContext.getCurrentInstance()
					.getExternalContext();
			return new DefaultStreamedContent(
					externalContext
							.getResourceAsStream("/resources/icons/avatar.png"));
		}
	}

	public void setPhoto(StreamedContent photo) {
		this.photo = photo;
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

}
