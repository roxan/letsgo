package edu.mum.waa.group9.services;

import edu.mum.waa.group9.DaoImp.PersonDaoImpl;
import edu.mum.waa.group9.beanImpl.Person;
import edu.mum.waa.group9.daoFacade.PersonDaoFacade;

public class PersonService {

	public void register(Person personBean) {
		PersonDaoFacade registerDao=new PersonDaoImpl();
		registerDao.registerPerson(personBean);		
	}
}
