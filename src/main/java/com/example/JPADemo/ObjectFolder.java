package com.example.JPADemo;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;


import com.example.JPADemo.TestFolder;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class ObjectFolder implements  Cloneable {

	private final StringProperty objectName;
	private final StringProperty myLocator;
	private final StringProperty myExpression;
	private final IntegerProperty repetition;
	private final StringProperty type;
	private final StringProperty elementType;
	private final StringProperty objectType;
	private final StringProperty objectPath;
	private final ObservableList<ObjectFolder> children;
	private final BooleanProperty isExpanded;
	//private StringProperty subType;
	//private List<TestFolder> testFolderID;
	private AddLocators additionalLocators;


	private List<TestFolder> refTestFolder;

	/*private TreeItem<ObjectFolder> objTreeItem;

	public void setTreeItem(TreeItem<ObjectFolder> objTreeItem) {
		this.objTreeItem = objTreeItem;
	}

	public TreeItem<ObjectFolder> getTreeItem(){
		return objTreeItem;
	}*/

	/**
	 * @return the refTestFolder
	 */
	@XmlIDREF
	public List<TestFolder> getRefTestFolder() {
		return refTestFolder;
	}

	/**
	 * @param refTestFolder the refTestFolder to set
	 */
	public void setRefTestFolder(List<TestFolder> refTestFolder) {
		this.refTestFolder = refTestFolder;
	}

	/**
	 * @return the additionalLocators
	 */
	@XmlElement(name="locators")
	public AddLocators getAdditionalLocators() {
		return additionalLocators;
	}

	/**
	 * @param additionalLocators the additionalLocators to set
	 */
	public void setAdditionalLocators(AddLocators additionalLocators) {
		this.additionalLocators = additionalLocators;
	}

	/**
	 * @return the testFolderID
	 */
	/*@XmlIDREF
    @XmlList
	public List<TestFolder> getTestFolderID() {
		return testFolderID;
	}

	*//**
	 * @param testFolderID the testFolderID to set
	 *//*
	public void setTestFolderID(List<TestFolder> testFolderID) {
		this.testFolderID = testFolderID;
	}*/

	/**
	 * Default constructor.
	 */
	public ObjectFolder() {
		this(null, null);
	}

	/**
	 * Constructor with some initial data.
	 *
	 * @param firstName
	 * @param lastName
	 */
	public ObjectFolder(String firstName, String lastName) {
		this.objectName = new SimpleStringProperty(firstName);
		this.myLocator = new SimpleStringProperty(lastName);

		// Some initial dummy data, just for convenient testing.
		this.myExpression = new SimpleStringProperty("some street");
		this.repetition = new SimpleIntegerProperty(1234);
		this.type = new SimpleStringProperty("some city");
		this.elementType = new SimpleStringProperty("element type");
		this.objectPath = new SimpleStringProperty("object Tree Path");
		this.objectType = new SimpleStringProperty("ObjectType");
		children = FXCollections.observableArrayList();
		refTestFolder = new ArrayList<TestFolder>();
		this.isExpanded = new SimpleBooleanProperty(true);
	}

	public ObjectFolder(String objectName, String myLocator, String myExpression, int repetition, String type,
			String elementType, String objectType, String objectTreePath) {
		super();
		this.objectName = new SimpleStringProperty(objectName);
		this.myLocator = new SimpleStringProperty(myLocator);
		this.myExpression = new SimpleStringProperty(myExpression);
		this.repetition = new SimpleIntegerProperty(repetition);
		this.type = new SimpleStringProperty(type);
		this.elementType = new SimpleStringProperty(elementType);
		this.objectType = new SimpleStringProperty(objectType);
		this.objectPath = new SimpleStringProperty(objectTreePath);
		children = FXCollections.observableArrayList();
		refTestFolder = new ArrayList<TestFolder>();
		this.isExpanded = new SimpleBooleanProperty(true);
	}

	public ObjectFolder(String objectName, String parameterValue, String actionMode, int repetition, String dataType,
			 String objectType, String objectTreePath) {
		super();
		this.objectName = new SimpleStringProperty(objectName);
		this.myLocator = new SimpleStringProperty(parameterValue);
		this.myExpression = new SimpleStringProperty(actionMode);
		this.repetition = new SimpleIntegerProperty(repetition);
		this.type = new SimpleStringProperty(dataType);
		this.elementType = new SimpleStringProperty("");
		this.objectType = new SimpleStringProperty(objectType);
		this.objectPath = new SimpleStringProperty(objectTreePath);
		children = FXCollections.observableArrayList();
		refTestFolder = new ArrayList<TestFolder>();
		this.isExpanded = new SimpleBooleanProperty(true);
	}

	public ObjectFolder(String objectName, String myLocator, String myExpression, String type,
			 String objectType, String objectPath) {
		super();
		this.objectName = new SimpleStringProperty(objectName);
		this.myLocator = new SimpleStringProperty(myLocator);
		this.myExpression = new SimpleStringProperty(myExpression);
		this.repetition = new SimpleIntegerProperty(1);
		this.type = new SimpleStringProperty(type);
		this.elementType = new SimpleStringProperty("");
		this.objectType = new SimpleStringProperty(objectType);
		this.objectPath = new SimpleStringProperty(objectPath);
		children = FXCollections.observableArrayList();
		refTestFolder = new ArrayList<TestFolder>();
		this.isExpanded = new SimpleBooleanProperty(true);
	}

	public boolean getIsExpanded(){
		return isExpanded.get();
	}

	public void setIsExpanded(boolean isExpanded){
		this.isExpanded.set(isExpanded);
	}

	public BooleanProperty isExpandedProperty(){
		return isExpanded;
	}

	public String getObjectName() {
		return objectName.get();
	}

	public void setObjectName(String objectName) {
		this.objectName.set(objectName);
	}

	public StringProperty objectNameProperty() {
		return objectName;
	}

	public String getMyLocator() {
		return myLocator.get();
	}

	public void setMyLocator(String myLocator) {
		this.myLocator.set(myLocator);
	}

	public StringProperty myLocatorProperty() {
		return myLocator;
	}

	public String getMyExpression() {
		return myExpression.get();
	}

	public void setMyExpression(String myExpression) {
		this.myExpression.set(myExpression);
	}

	public StringProperty myExpressionProperty() {
		return myExpression;
	}

	public int getRepetition() {
		return repetition.get();
	}

	public void setRepetition(int postalCode) {
		this.repetition.set(postalCode);
	}

	public IntegerProperty repetitionProperty() {
		return repetition;
	}

	public String getType() {
		return type.get();
	}

	public void setType(String city) {
		this.type.set(city);
	}

	public StringProperty typeProperty() {
		return type;
	}



	public StringProperty getElementTypeProperty() {
		return elementType;
	}

	public final StringProperty objectTypeProperty() {
		return this.objectType;
	}

	public final String getObjectType() {
		return this.objectTypeProperty().get();
	}

	public final void setObjectType(final String objectType) {
		this.objectTypeProperty().set(objectType);
	}

	public final void setElementType(final String elementType) {
		getElementTypeProperty().set(elementType);
	}

	public final String getElementType() {
		return this.getElementTypeProperty().get();
	}



	public final StringProperty objectPathProperty() {
		return this.objectPath;
	}

	@XmlID
	@XmlElement(name="objectpath")
	public final String getObjectPath() {
		return this.objectPathProperty().get();
	}

	public final void setObjectPath(final String objectTreePath) {
		this.objectPathProperty().set(objectTreePath);
	}


	@XmlElement(name = "childern")
	public final ObservableList<ObjectFolder> getChildren() {
		return children;
	}

	public boolean isHasChildren() {
		if (getChildren().size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isTestStep() {
		if (getChildren().size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ObjectFolder [objectName=" + objectName + ", myLocator=" + myLocator + ", myExpression=" + myExpression
				+ ", repetition=" + repetition + ", type=" + type + ", birthday=" + elementType + ", objectType="
				+ objectType + ", objectPath=" + objectPath + ", children=" + children + ", testFolderID="
				+ /*testFolderID +*/ "]";
	}

	/**
	 * @param observable
	 * @see javafx.beans.property.Property#bind(javafx.beans.value.ObservableValue)
	 */
	public void bind(ObservableValue<? extends String> observable) {
		objectPath.bind(observable);
	}

	public ObjectFolder clone() throws CloneNotSupportedException {
		return (ObjectFolder) super.clone();
	}

	/*public final StringProperty subTypeProperty() {
		return this.subType;
	}


	public final String getSubType() {
		return this.subTypeProperty().get();
	}


	public final void setSubType(final String subType) {
		this.subTypeProperty().set(subType);
	}*/




}