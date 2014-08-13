package edu.mum.waa.group9.daoFacade;

import javax.sql.rowset.CachedRowSet;

import edu.mum.waa.group9.beanInterfaces.PersonInterface;

public interface PersonDaoFacade {
	public CachedRowSet getUnameAndPassword(String email);

	public boolean registerPerson(PersonInterface personBean);

	public CachedRowSet getOfferedRides(PersonInterface person);
}
