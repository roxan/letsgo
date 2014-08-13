package edu.mum.waa.group9.daoFacade;

import javax.sql.rowset.CachedRowSet;

import org.primefaces.model.UploadedFile;

import edu.mum.waa.group9.beanInterfaces.PersonInterface;

public interface PersonDaoFacade {
	public CachedRowSet getUnameAndPassword(String email, String password);

	public boolean registerPerson(PersonInterface personBean);

	public void saveImage(UploadedFile file, int pid);
}
