package edu.mum.waa.group9.services;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.rowset.CachedRowSet;

import edu.mum.waa.group9.DaoImp.PersonDaoImpl;
import edu.mum.waa.group9.beanImpl.Login;
import edu.mum.waa.group9.beanImpl.Person;
import edu.mum.waa.group9.daoFacade.PersonDaoFacade;


public class LoginService {
	CachedRowSet personRow;
	PersonDaoFacade personFacade = new PersonDaoImpl();
	Person person = new Person();
 
	public boolean doLogin(String email,String password){
	 personRow=personFacade.getUnameAndPassword(email,password);
	 if(personRow!=null){
		 return false;
	 }
	 try {
	person.setId(personRow.getInt("ID"));
	person.setFirstName(personRow.getString("FIRSTNAME"));
	person.setLastName(personRow.getString("LASTNAME"));
	person.setEmail(personRow.getString("EMAIL"));
	person.setPassword(personRow.getString("PASSWORD"));
	person.setPhone(personRow.getString("PHONE"));
	
	
	 }catch (SQLException e) {
			e.printStackTrace();
		}
	 return true;
 }
}



