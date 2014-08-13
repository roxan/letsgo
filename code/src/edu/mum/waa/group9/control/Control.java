package edu.mum.waa.group9.control;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import edu.mum.waa.group9.beanImpl.Login;
import edu.mum.waa.group9.beanImpl.Person;
import edu.mum.waa.group9.beanImpl.PersonAddress;
import edu.mum.waa.group9.beanImpl.Ride;
import edu.mum.waa.group9.beanImpl.Search;
import edu.mum.waa.group9.services.LoginService;
import edu.mum.waa.group9.services.PersonService;
import edu.mum.waa.group9.services.SearchService;
import edu.mum.waa.group9.utils.MessagesUtil;

@Named("control")
@SessionScoped
public class Control implements Serializable {
	@Inject
	private Search searchBean;
	@Inject
	private Person personBean;
	@Inject
	PersonAddress personAddress;
	@Inject
	private Login login;

	private boolean loggedIn;
	private boolean loginfailure = false;
	private String confirmPassword;
	private String requestedUrl;

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

	public String checkLogin() {
		System.out.println("Inside checkLogin***");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext()
				.getRequestParameterMap();
		requestedUrl = params.get("url");

		Ride currRide = currentRideFromRideList();
		if (currRide != null) {
			System.out.println("currRide.getId-->" + currRide.getId());
			searchBean.setCurrentRide(currRide);
		} else {
			System.out.println("No Ride Found");

		}

		if (loggedIn) {
			return requestedUrl;
		} else {
			return "rideDetail";
		}

	}

	public Ride currentRideFromRideList() {
		Ride retVal = null;
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext()
				.getRequestParameterMap();

		String rideIdStr = params.get("rideId");
		System.out.println("rideIdStr is --> " + rideIdStr);
		for (Ride r : searchBean.getRideList()) {
			if (r.getId() == Integer.parseInt(rideIdStr)) {
				retVal = r;
			}
		}
		return retVal;
	}

	public String doLogin() {
		LoginService ls = new LoginService();
		loggedIn = ls.doLogin(personBean, login);
		// System.out.println("logged:"+loggedIn);
		if (loggedIn) {
			return "changePassword";
		} else {
			loginfailure = true;
			// MessagesUtil.displayError("you no login");
			return "index";
		}
	}

	public String goToRegister() {
		return "register";
	}

	public String changePassword() {
		LoginService ls = new LoginService();
		boolean passwordChanged = ls.changePassword(personBean, login);
		System.out.println("inside changepassord:" +passwordChanged);
		return "";
	}

	public void handleFileUpload(FileUploadEvent event) {
		PersonService personServ = new PersonService();
		personServ.handleFileUpload(event.getFile(), personBean.getId());
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

	public String getRequestedUrl() {
		return requestedUrl;
	}

	public void setRequestedUrl(String requestedUrl) {
		this.requestedUrl = requestedUrl;
	}

	public boolean getLoginfailure() {
		return loginfailure;
	}

	public void setLoginfailure(boolean loginfailure) {
		this.loginfailure = loginfailure;
	}

	private static final long serialVersionUID = 6063138477024970939L;

}
