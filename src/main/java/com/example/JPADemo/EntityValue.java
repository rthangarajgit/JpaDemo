package com.example.JPADemo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EntityValue {


	StringProperty value;
	StringProperty type;


	public EntityValue() {
		value = new SimpleStringProperty("");
	}

	public EntityValue(StringProperty value) {
		super();
		this.value = value;
	}
	public EntityValue(String value) {
		super();
		this.value = new SimpleStringProperty(value);
	}

	public EntityValue(StringProperty value, StringProperty type) {
		super();
		this.value = value;
		this.type = type;
	}
	public EntityValue(String value, String type) {
		super();
		this.value = new SimpleStringProperty(value);
		this.type = new SimpleStringProperty(type);
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


	public final StringProperty typeProperty() {
		return this.type;
	}


	public final String getType() {
		if(this.typeProperty()==null){
			return "normal";
		}
		return this.typeProperty().get();
	}


	public final void setType(final String type) {
		if(this.typeProperty()==null){
			this.type = new SimpleStringProperty(type);
		}
		this.typeProperty().set(type);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value.get();
	}



}


