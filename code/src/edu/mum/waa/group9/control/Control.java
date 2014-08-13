package edu.mum.waa.group9.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.mum.waa.group9.beanImpl.Person;
import edu.mum.waa.group9.beanImpl.PersonAddress;
import edu.mum.waa.group9.beanImpl.Search;
import edu.mum.waa.group9.services.PersonService;
import edu.mum.waa.group9.services.SearchService;

@Named("control")
@SessionScoped
public class Control implements Serializable {
	@Inject
	private Search searchBean;
	@Inject
	private Person personBean;
	@Inject
	PersonAddress personAddress;

	private boolean loggedIn;
	private String confirmPassword;

	public String search() {
		SearchService searchServ = new SearchService();
		searchServ.search(searchBean);
		return "searchResult";
	}

	public String registerPerson() {
		PersonService personServ = new PersonService();
		personBean.setAddress(personAddress);
		personBean.setRegistered(personServ.register(personBean));
		System.out.println("Boolean Checked: " + personBean.isRegistered());
		return "registration_status";
	}

	public String checkLogin(){
		return null;
	}

	public Search getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(Search searchBean) {
		this.searchBean = searchBean;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	private static final long serialVersionUID = 6063138477024970939L;

}
