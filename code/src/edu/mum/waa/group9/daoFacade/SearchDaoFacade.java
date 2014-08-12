package edu.mum.waa.group9.daoFacade;

import javax.sql.rowset.CachedRowSet;

import edu.mum.waa.group9.beanInterfaces.SearchInterface;

public interface SearchDaoFacade {
	public CachedRowSet search(SearchInterface searchBean);

}
