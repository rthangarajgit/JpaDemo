package com.example.JPADemo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlRootElement(name="entities")
public class TestSheetListWrapper {

	
	ObservableList<EntityS> testEntities;

	public TestSheetListWrapper() {
		testEntities = FXCollections.observableArrayList();
	}
	
	public TestSheetListWrapper(ObservableList<EntityS> testEntities) {
		super();
		this.testEntities = testEntities;
	}

	/**
	 * @return the testSheets
	 */
	@XmlElement(name="testEntities")
	public ObservableList<EntityS> getTestEntities() {
		return testEntities;
	}

	/**
	 * @param testSheets the testSheets to set
	 */
	public void setTestEntities(ObservableList<EntityS> testEntities) {
		this.testEntities = testEntities;
	}
	
	public void addTestSheet(EntityS testEntity) {
		if(testEntities!=null) {
			testEntities.add(testEntity);
		}else {
			testEntities = FXCollections.observableArrayList();
		}
		
	}
}
