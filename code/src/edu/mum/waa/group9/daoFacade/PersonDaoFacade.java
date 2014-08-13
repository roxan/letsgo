package edu.mum.waa.group9.daoFacade;

import javax.sql.rowset.CachedRowSet;

import edu.mum.waa.group9.beanInterfaces.LoginInterface;
import edu.mum.waa.group9.beanInterfaces.PersonInterface;


public interface PersonDaoFacade {
	public void registerPerson(PersonInterface personBean);
	public CachedRowSet getUnameAndPassword(String email);
}
