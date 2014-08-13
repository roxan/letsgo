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

	public boolean doLogin(String email, String password) {
		personRow = personFacade.getUnameAndPassword(email, password);
		
		if (personRow == null) {
			return false;
		} else
			try {
				if(personRow.next()) {
					try {
						
						person.setId(personRow.getInt("ID"));
						person.setFirstName(personRow.getString("FIRST_NAME"));
						person.setLastName(personRow.getString("LAST_NAME"));
						person.setEmail(personRow.getString("EMAIL"));
						person.setPassword(personRow.getString("PASSWORD"));
						person.setPhone(personRow.getString("PHONE"));
						person.setSex(personRow.getString("SEX"));
						return true;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}
	public boolean changePassword(Person person1, Login login1) {
		if(person1.getPassword().equals(login1.getOldPassword())){
			
			
			return true;
		}
		return false;	
		}
		
		
	
}
