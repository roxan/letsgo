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
import edu.mum.waa.group9.exceptions.RulesException;
import edu.mum.waa.group9.services.LoginService;
import edu.mum.waa.group9.services.PersonService;
import edu.mum.waa.group9.services.RideService;
import edu.mum.waa.group9.services.SearchService;
import edu.mum.waa.group9.utils.DateUtil;
import edu.mum.waa.group9.utils.MessageProvider;
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
	@Inject
	private Ride rideBean;

	private boolean loggedIn = false;
	private boolean loginfailure = false;
	private String confirmPassword;
	private String requestedUrl;
	private String callingPage;

	public String runRules() {
		String retVal = null;
		try {
			checkDepartDateRule();
			retVal = search();
		} catch (RulesException e) {
			MessagesUtil.displayError(e.getMessage());
		} finally {
			return retVal;
		}
	}

	public void checkDepartDateRule() throws RulesException {
		long timeDifference = searchBean.getToDate().getTime()
				- searchBean.getFromDate().getTime();

		if (timeDifference <= 0) {
			throw new RulesException(
					MessageProvider
							.getValue("returnDateSmallerThanDepartDateError"));
		}
	}

	public String search() {
		SearchService searchServ = new SearchService();
		searchServ.search(searchBean);
		return "searchResult?faces-redirect=true";
	}

	public String doSearch() {
		return runRules();
	}

	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
	}

	public String registerPerson() {
		PersonService personServ = new PersonService();
		personBean.setAddress(personAddress);
		personBean.setAge(DateUtil.ageInYears(personBean.getDob()));
		personBean.setRegistered(personServ.register(personBean));
		return "registration_status?faces-redirect=true";
	}

	public String createRide() {
		System.out.println("Inside Control--createRide");
		rideBean.setPerson(personBean);
		RideService rideServ = new RideService();
		boolean createSuccess = rideServ.createRide(rideBean);
		if (createSuccess)
			return "userPanel";
		else
			return null;
	}

	public String checkLogin() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext()
				.getRequestParameterMap();
		requestedUrl = params.get("url");

		Ride currRide = currentRideFromRideList();
		if (currRide != null) {
			searchBean.setCurrentRide(currRide);
		}

		if (loggedIn) {
			return requestedUrl;
		} else {
			callingPage = FacesContext.getCurrentInstance().getViewRoot()
					.getViewId();
			return "login?faces-redirect=true";
		}
	}

	public Ride currentRideFromRideList() {
		Ride retVal = null;
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext()
				.getRequestParameterMap();

		String rideIdStr = params.get("rideId");
		for (Ride r : searchBean.getRideList()) {
			if (r.getId() == Integer.parseInt(rideIdStr)) {
				retVal = r;
			}
		}
		return retVal;
	}

	public String doLogin() {
		LoginService ls = new LoginService();
		loggedIn = ls.doLogin(personBean, login, personAddress);

		if (loggedIn) {
			if (null != callingPage && callingPage.contains("searchResult"))
				return "rideDetail";
			else
				return "userPanel?faces-redirect=true";

		} else {
			loginfailure = true;
			return "login?faces-redirect=true";
		}
	}

	public String goToRegister() {
		return "register?faces-redirect=true";
	}

	public void changePassword() {
		LoginService ls = new LoginService();
		ls.changePassword(personBean, login);
	}

	public void handleFileUpload(FileUploadEvent event) {
		PersonService personServ = new PersonService();
		personServ.handleFileUpload(event.getFile(), personBean.getId());
	}

	public String offeredRides() {
		PersonService personServ = new PersonService();
		personServ.getOfferedRides(personBean);
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
