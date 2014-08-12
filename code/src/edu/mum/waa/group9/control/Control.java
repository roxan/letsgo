package edu.mum.waa.group9.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import edu.mum.waa.group9.beanImpl.Search;
import edu.mum.waa.group9.beanInterfaces.SearchInterface;
import edu.mum.waa.group9.services.SearchService;

@Named("control")
@SessionScoped
public class Control implements Serializable {
	@Inject
	private Search searchBean;
	private boolean loggedIn;

	public String search() {
		System.out.println("Inside Control -- > Search");
		SearchService searchServ = new SearchService();
		searchServ.search(searchBean);
		System.out.println("Control --> searchBean--rideList--source: "
				+ searchBean.getRideList().get(0).getSource());
		return "searchResult";
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

	private static final long serialVersionUID = 6063138477024970939L;
}
