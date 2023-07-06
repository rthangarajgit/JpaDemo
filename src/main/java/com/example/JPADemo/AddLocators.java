package com.example.JPADemo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;


import com.example.JPADemo.Locator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//@XmlRootElement(name="locators")
public class AddLocators {

	List<Locator> Locators;

	public AddLocators() {
			Locators = new ArrayList<Locator>();

	}

	public AddLocators(List<List<String>> lstAdditionalLocators) {
		super();
		for (List<String> s1 : lstAdditionalLocators) {
			String strRawLocator = s1.get(0);
			String strIdentifier = s1.get(1);
			String locatorType = strRawLocator.split("=", 2)[0];
			String locatorExpression = strRawLocator.split("=", 2)[1];
			Locator myLocator = new Locator(strIdentifier, locatorType, locatorExpression);
			if (Locators != null) {
				Locators.add(myLocator);
			} else {
				Locators = new ArrayList<Locator>();
				Locators.add(myLocator);
			}

		}
		// this.additionalLocators = additionalLocators;

	}

	/**
	 * @return the locators
	 */
	@XmlElement(name = "additionalLocators")
	public List<Locator> getLocators() {
		return Locators;
	}

	public boolean checkExistAddLocator(Locator newLocator) {

		int lastNumber = 0;

		ObservableList<String> lstStringLocatorType = FXCollections.observableArrayList();
		ObservableList<String> lstStringExpression = FXCollections.observableArrayList();

		for (int i = 0; i < Locators.size(); i++) {
			Locator actualLocator = Locators.get(i);
			String identifier = actualLocator.getIdentifier();
			String[] arrIdentifier = identifier.split(":");
			if (arrIdentifier.length > 1) {
				if (isNumeric(arrIdentifier[1])) {
					lastNumber = lastNumber + Integer.parseInt(arrIdentifier[1]);
				}
			}
			lstStringLocatorType.add(actualLocator.getLocator());
			lstStringExpression.add(actualLocator.getExpression());
		}
		System.out.println(newLocator.getLocator());
		if (lstStringLocatorType.contains(newLocator.getLocator())
				&& !lstStringExpression.contains(newLocator.getExpression())) {
			newLocator.setIdentifier(newLocator.getIdentifier() + ":" + (lastNumber + 1));
			Locators.add(newLocator);
			return true;
		} else if (!lstStringLocatorType.contains(newLocator.getLocator())
				&& lstStringExpression.contains(newLocator.getExpression())) {
			newLocator.setIdentifier(newLocator.getIdentifier() + ":" + (lastNumber + 1));
			Locators.add(newLocator);
			return true;
		}

		return false;

	}

	public ObservableList<String> getLocatorsType() {
		ObservableList<String> lstStringLocatorType = FXCollections.observableArrayList();
		for (Locator loc : Locators) {
			lstStringLocatorType.add(loc.getIdentifier());

		}
		if (!lstStringLocatorType.contains("xpath")) {
			lstStringLocatorType.add("xpath");
		}
		if (!lstStringLocatorType.contains("id")) {
			lstStringLocatorType.add("id");
		}
		if (!lstStringLocatorType.contains("name")) {
			lstStringLocatorType.add("name");
		}
		return lstStringLocatorType;
	}

	public String getExpressionByLocatorId(String loacatorId) {
		String myExpression = "";
		for (Locator loc : Locators) {
			if (loc.getIdentifier().equalsIgnoreCase(loacatorId)) {
				myExpression = loc.getExpression();
				return myExpression;
			}

		}
		return myExpression;
	}

	public Locator getLocatorByLocatorId(String loacatorId) {
		Locator myExpression = null;
		for (Locator loc : Locators) {
			if (loc.getIdentifier().equalsIgnoreCase(loacatorId)) {
				return loc;
			}

		}
		return myExpression;
	}

	/**
	 * @param locators
	 *            the locators to set
	 */
	public void setLocators(List<Locator> locators) {
		Locators = locators;
	}

	public  boolean isNumeric(String str) {
		  try {
		    Double.parseDouble(str);
		    return true;
		  } catch(NumberFormatException e){
		    return false;
		  }
		}

}
