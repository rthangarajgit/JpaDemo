package com.example.JPADemo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Instance extends EntityS{



	StringProperty value;

	public Instance() {
		value = new SimpleStringProperty();
	}

	public Instance(StringProperty value) {
		super();
		this.value = value;
	}

	public Instance(String value) {
		super();
		this.value = new SimpleStringProperty(value);
	}


	public final StringProperty valueProperty() {
		return this.value;
	}


	public final String getValue() {
		return this.valueProperty().get();
	}


	public final void setValue(final String value) {
		this.valueProperty().set(value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Instance [value=" + value + "]";
	}




}
