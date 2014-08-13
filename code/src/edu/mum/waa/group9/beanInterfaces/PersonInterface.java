package edu.mum.waa.group9.beanInterfaces;

import org.primefaces.model.StreamedContent;

import edu.mum.waa.group9.beanImpl.PersonAddress;

public interface PersonInterface {
	public String getFirstName();

	public String getLastName();

	public StreamedContent getPhoto();

	public String getSex();

	public String getPhone();

	public String getEmail();

	public String getPassword();

	public PersonAddress getAddress();

	public String getFullName();

	// setters..............

	public void setId(int Id);

	public void setFirstName(String firstName);

	public void setLastName(String lastName);

	public void setSex(String sex);

	public void setEmail(String email);

	public void setPassword(String password);

	public void setAddress(PersonAddress address);

	public void setPhoto(StreamedContent photo);
}
