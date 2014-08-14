package edu.mum.waa.group9.services;

import java.io.InputStream;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import org.primefaces.model.DefaultStreamedContent;

import edu.mum.waa.group9.DaoImp.PersonDaoImpl;
import edu.mum.waa.group9.beanImpl.Login;
import edu.mum.waa.group9.beanImpl.Person;
import edu.mum.waa.group9.beanImpl.PersonAddress;
import edu.mum.waa.group9.daoFacade.PersonDaoFacade;

public class LoginService {
	CachedRowSet personRow;
	PersonDaoFacade personFacade = new PersonDaoImpl();

	public boolean doLogin(Person person, Login login, PersonAddress address) {
		personRow = personFacade.getPersonAndAddress(login.getUserName(),login.getPassword());

		if (personRow == null) {
			return false;
		} else
			try {
				if (personRow.next()) {
					try {
						address.setId(personRow.getInt("ID"));
						address.setCity(personRow.getString("CITY"));
						address.setCountry(personRow.getString("COUNTRY"));
						address.setState(personRow.getString("STATE"));
						address.setStreet(personRow.getString("STREET"));
						address.setZip(personRow.getString("ZIP"));
						person.setId(personRow.getInt("ID"));
						person.setFirstName(personRow.getString("FIRST_NAME"));
						person.setLastName(personRow.getString("LAST_NAME"));
						person.setEmail(personRow.getString("EMAIL"));
						person.setPassword(personRow.getString("PASSWORD"));
						person.setPhone(personRow.getString("PHONE"));
						person.setSex(personRow.getString("SEX"));
						if (null != personRow.getBlob("AVATAR")) {
							InputStream bs = personRow.getBlob("AVATAR")
									.getBinaryStream();
							DefaultStreamedContent dsc = new DefaultStreamedContent(
									bs);
							person.setPhoto(dsc);
						}
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
		String password=person1.getPassword();
		String password1=login1.getPassword();
		 if(password.equals(password1)){
			 personFacade.updatePassword(person1.getId(), login1.getNewPassword());
			return true;
		}
		return false;
	}

}
