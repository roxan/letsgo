package edu.mum.waa.group9.beanInterfaces;

import java.sql.Blob;

import edu.mum.waa.group9.beanImpl.Person;
import edu.mum.waa.group9.beanImpl.PersonAddress;

public interface PersonInterface {
	public String getFirstName();
	public String getLastName();
	public Blob getPhoto();
	
	public void setId(int Id);
	public void setFirstName(String firstName);
	public void setLastName(String lastName);
	public void setSex(String sex);
	public void setEmail(String email);
	public void setPassword(String password);
	public void setAddress(PersonAddress address);
	public void setPhoto(Blob photo);
}
