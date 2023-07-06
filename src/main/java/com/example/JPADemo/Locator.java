package com.example.JPADemo;

public class Locator {

	String identifier;
	String locator;
	String expression;
	
	public Locator() {
		
	}
	
	public Locator(String identifier, String locator, String expression) {
		super();
		this.identifier = identifier;
		this.locator = locator;
		this.expression = expression;
	}


	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}


	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the locator
	 */
	public String getLocator() {
		return locator;
	}


	/**
	 * @return the expression
	 */
	public String getExpression() {
		return expression;
	}


	/**
	 * @param locator the locator to set
	 */
	public void setLocator(String locator) {
		this.locator = locator;
	}


	/**
	 * @param expression the expression to set
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
