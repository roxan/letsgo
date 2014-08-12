package edu.mum.waa.group9.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.mum.waa.group9.beanImpl.Search;
import edu.mum.waa.group9.beanInterfaces.SearchInterface;
import edu.mum.waa.group9.services.SearchService;

@Named("control")
@SessionScoped
public class Control implements Serializable{
	@Inject
	private Search searchBean;
	
	private boolean loggedIn;
	
	
	
	public String search(){
		SearchService searchServ = new SearchService();
		searchServ.search(searchBean);
		return "showResult";
	}

}
