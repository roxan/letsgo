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
import edu.mum.waa.group9.services.SearchService;
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

	private boolean loggedIn;
	private boolean loginfailure = false;
	private String confirmPassword;
	private String requestedUrl;

	public String runRules() {
		System.out.println("Inside runRules");
		String retVal = null;
		try {
			checkDepartDateRule();
			retVal = search();
		} catch (RulesException e) {
			System.out.println("Inside runRules --> catch block"
					+ e.getMessage());
			MessagesUtil.displayError(e.getMessage());
		} finally {
			return retVal;
		}
	}

	public void checkDepartDateRule() throws RulesException {
		long timeDifference = searchBean.getToDate().getTime()
				- searchBean.getFromDate().getTime();

		System.out.println("searchBean.getToDate().getTime() -- > "
				+ searchBean.getToDate().getTime());
		System.out.println("searchBean.getFromDate().getTime() -- > "
				+ searchBean.getToDate().getTime());
		System.out.println("timeDifference -- > " + timeDifference);

		if (timeDifference <= 0) {
			throw new RulesException(
					MessageProvider
							.getValue("returnDateSmallerThanDepartDateError"));
		}
	}

	public String search() {
		SearchService searchServ = new SearchService();
		searchServ.search(searchBean);
		return "searchResult";
	}

	public String doSearch() {
		return runRules();
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

		if (loggedIn) {
			Ride currRide = currentRideFromRideList();
			if (currRide != null) {
				System.out.println("currRide.getId-->" + currRide.getId());
				searchBean.setCurrentRide(currRide);
			}
			return requestedUrl;
		} else {
			return "login";
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
		loggedIn = ls.doLogin(login.getUserName(), login.getPassword());
		//System.out.println("logged:"+loggedIn);
		if (loggedIn) {

			FacesContext fc = FacesContext.getCurrentInstance();
			Map<String, String> params = fc.getExternalContext()
					.getRequestParameterMap();

			String rideSeekerStr = params.get("rideSeeker");
			System.out
					.println("Inside Control--dologin--params.get(rideSeeker) = "
							+ params.get("rideSeeker"));
			System.out.println("Inside Control--dologin--rideSeekerStr = "
					+ rideSeekerStr);

			if (rideSeekerStr != null) {
				System.out
						.println("Inside Control--dologin--rideIdStr not null***");
				return "rideDetail";
			} else
				return "register";

		} else {
			loginfailure = true;
			System.out.println("Inside Control--dologin--loggedIn = false***");
			return "login";

		}
	}

	public String goToRegister(){
		return "register";
	}

	public void changePassword() {
		LoginService ls = new LoginService();
		//boolean passwordChanged = ls.changePassword(login,personBean);
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
