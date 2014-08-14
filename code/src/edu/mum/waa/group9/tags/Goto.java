package edu.mum.waa.group9.tags;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import edu.mum.waa.group9.utils.MessageProvider;

@Named("goto")
@SessionScoped
public class Goto implements Serializable {
	private String selectedPage;
	private static Map<String,String> myMap;
	static
    {
        myMap = new HashMap<String, String>();
        myMap.put(MessageProvider.getValue("tagLogin"),"login");
        myMap.put(MessageProvider.getValue("tagHome"),"index");
        myMap.put(MessageProvider.getValue("tagRegister"),"register");
        myMap.put(MessageProvider.getValue("tagLogout"),"logout");
        
    }

	public String getSelectedPlanet() {
		return selectedPage;
	}

	public String gotoPage(String key) {
		selectedPage = myMap.get(key);
		return selectedPage;
	}
}
