package edu.mum.waa.group9.beanImpl;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("goto")
@SessionScoped
public class Goto implements Serializable {
	private String selectedPage;
	  
	

	public String getSelectedPlanet() { 
		  return selectedPage; 
		  }
	  
	  public String gotoPage(String newValue) {
	     selectedPage = newValue;
	     return selectedPage;
	  }
}
