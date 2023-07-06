package com.example.JPADemo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.json.JSONArray;
import org.json.JSONObject;




import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import jfxtras.internal.scene.control.skin.agenda.icalendar.base24hour.popup.SimpleEditSceneFactory;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */


@XmlRootElement(name="testfolder")
@Entity
@Table (name="TestFolder")
public class TestFolder implements Cloneable{




	private final StringProperty objectName;
	private final StringProperty parameterValue;
	private final StringProperty actionMode;
	private final StringProperty repetition;
	private final StringProperty dataType;
	private final ObjectProperty jsonobject;
	private final ObjectProperty parent;
	private final StringProperty objectType;
	private final StringProperty objectTreePath;
	private final StringProperty thisStepTreePath;
	private final ObservableList<TestFolder> children;
	//private BooleanProperty breakCol;
	private ObjectFolder objectFolder;
	private EntityS entityS;
	private StringProperty testFolderID;

	private TestFolder parentTestFolder;
	private StringProperty tdCondition;


	private StringProperty result;
	private StringProperty resultDescription;
	private final StringProperty isExpanded;
	private final BooleanProperty isBreak;
	private final BooleanProperty screenshot;
	private final BooleanProperty isSkip;

	private final StringProperty entityRef;

	private String key;
    private Object json;
    private Integer index;


    @XmlIDREF
	public TestFolder getParentTestFolder() {
		return parentTestFolder;
	}
    public void setParentTestFolder(TestFolder parentTestFolder) {
		this.parentTestFolder = parentTestFolder;
	}



   /* public StringProperty testFolderProperty() {
		return this.testFolderid;
	}

	@XmlID
	public String getTestFolderid() {
		return this.testFolderidProperty().get();
	}

	public void setTestFolderid(final String testFolderid) {
		if(this.testFolderid==null){
			this.testFolderid = new SimpleStringProperty();
		}
		this.testFolderidProperty().set(testFolderid);
	}*/

	/*public void createEntityId() {

		setTestFolderid(this.hashCode() + "");
	}*/


	/**
	 * @return the entity
	 */
	@XmlIDREF
	@XmlElement(name = "entity")
	public EntityS getEntity() {
		return entityS;
	}

	/**
	 * @param entityS the entity to set
	 */
	public void setEntity(EntityS entityS) {
		this.entityS = entityS;
	}

	/**
	 * @return the objectFolder
	 */
	@XmlIDREF
	@XmlElement(name = "objectpath")
	public ObjectFolder getObjectFolder() {
		return objectFolder;
	}

	/**
	 * @param objectFolder
	 *            the objectFolder to set
	 */
	public void setObjectFolder(ObjectFolder objectFolder) {
		this.objectFolder = objectFolder;
	}



	public TestFolder(Integer index, Object json, Object parent) {
		super();
        this.index = index;
        this.json = json;
        this.parent = new SimpleObjectProperty(parent);

		this.objectName = new SimpleStringProperty();
		this.parameterValue = new SimpleStringProperty(this.json.toString());
		this.actionMode = new SimpleStringProperty();
		this.repetition = new SimpleStringProperty();
		this.dataType = new SimpleStringProperty();
		this.jsonobject = new SimpleObjectProperty();

		this.objectType = new SimpleStringProperty();
		this.objectTreePath = new SimpleStringProperty();
		this.thisStepTreePath = new SimpleStringProperty();
		children = FXCollections.observableArrayList();
		this.testFolderID = new SimpleStringProperty(this.hashCode() + "");
		this.entityS = new EntityS();
		this.result=new SimpleStringProperty("NULL");
		this.resultDescription= new SimpleStringProperty("NULL");
		this.tdCondition = new SimpleStringProperty("");
		this.isExpanded = new SimpleStringProperty();
		this.isBreak = new SimpleBooleanProperty();
		this.screenshot = new SimpleBooleanProperty(true);
		this.isSkip = new SimpleBooleanProperty();
		this.entityRef = new SimpleStringProperty();

    }


	public TestFolder(String key, Object json, Object parent) {
		super();
        this.key = key;
        this.json = json;
        this.parent = new SimpleObjectProperty(parent);


		this.objectName = new SimpleStringProperty(this.key);
		this.parameterValue = new SimpleStringProperty(this.json.toString());
		this.actionMode = new SimpleStringProperty();
		this.repetition = new SimpleStringProperty();
		this.dataType = new SimpleStringProperty();
		this.jsonobject = new SimpleObjectProperty();

		this.objectType = new SimpleStringProperty();
		this.objectTreePath = new SimpleStringProperty();
		this.thisStepTreePath = new SimpleStringProperty();
		children = FXCollections.observableArrayList();
		this.testFolderID = new SimpleStringProperty(this.hashCode() + "");
		this.entityS = new EntityS();
		this.result=new SimpleStringProperty("NULL");
		this.resultDescription= new SimpleStringProperty("NULL");
		this.tdCondition = new SimpleStringProperty("");
		this.isExpanded = new SimpleStringProperty();
		this.isBreak = new SimpleBooleanProperty();
		this.screenshot = new SimpleBooleanProperty(true);
		this.isSkip = new SimpleBooleanProperty();
		this.entityRef = new SimpleStringProperty();
    }


	/**
	 * Default constructor.
	 */
	public TestFolder() {
		super();
		this.objectName = new SimpleStringProperty();
		this.parameterValue = new SimpleStringProperty();
		this.actionMode = new SimpleStringProperty();
		this.repetition = new SimpleStringProperty();
		this.dataType = new SimpleStringProperty();
		this.jsonobject = new SimpleObjectProperty();
		this.parent = new SimpleObjectProperty();
		this.objectType = new SimpleStringProperty();
		this.objectTreePath = new SimpleStringProperty();
		this.thisStepTreePath = new SimpleStringProperty();
		children = FXCollections.observableArrayList();
		this.testFolderID = new SimpleStringProperty();
		this.entityS = new EntityS();
		this.result=new SimpleStringProperty("NULL");
		this.resultDescription= new SimpleStringProperty("NULL");
		this.tdCondition = new SimpleStringProperty("");
		this.isExpanded = new SimpleStringProperty();
		this.isBreak = new SimpleBooleanProperty();
		this.screenshot = new SimpleBooleanProperty(true);
		this.isSkip = new SimpleBooleanProperty();
		this.entityRef = new SimpleStringProperty();
	}

	/**
	 * Constructor with some initial data.
	 *
	 * @param firstName
	 * @param lastName
	 */

	public TestFolder(String objectName, String objectType, boolean name) {
		if(name){
			this.objectName = new SimpleStringProperty(objectName);
		}else{
			this.objectName = new SimpleStringProperty();
		}

		this.parameterValue = new SimpleStringProperty();

		// Some initial dummy data, just for convenient testing.
		this.actionMode = new SimpleStringProperty("some street");
		this.repetition = new SimpleStringProperty();
		this.dataType = new SimpleStringProperty("some city");
		this.jsonobject = new SimpleObjectProperty();
		this.parent = new SimpleObjectProperty();
		this.objectTreePath = new SimpleStringProperty("object Tree Path");
		this.thisStepTreePath = new SimpleStringProperty();
		this.objectType = new SimpleStringProperty(objectType);
		children = FXCollections.observableArrayList();
		this.testFolderID = new SimpleStringProperty(this.hashCode() + "");
		this.entityS = new EntityS();
		this.result=new SimpleStringProperty("NULL");
		this.resultDescription= new SimpleStringProperty("NULL");
		this.tdCondition = new SimpleStringProperty("");
		this.isExpanded = new SimpleStringProperty("true");
		this.isBreak = new SimpleBooleanProperty();
		this.screenshot = new SimpleBooleanProperty(true);
		this.isSkip = new SimpleBooleanProperty();
		this.entityRef = new SimpleStringProperty();
	}

	public TestFolder(String objectType) {
		this.objectName = new SimpleStringProperty();
		this.parameterValue = new SimpleStringProperty();

		// Some initial dummy data, just for convenient testing.
		this.actionMode = new SimpleStringProperty("some street");
		this.repetition = new SimpleStringProperty();
		this.dataType = new SimpleStringProperty("some city");
		this.jsonobject = new SimpleObjectProperty();
		this.parent = new SimpleObjectProperty();
		this.objectTreePath = new SimpleStringProperty("object Tree Path");
		this.thisStepTreePath = new SimpleStringProperty();
		this.objectType = new SimpleStringProperty(objectType);
		children = FXCollections.observableArrayList();
		this.testFolderID = new SimpleStringProperty(this.hashCode() + "");
		this.entityS = new EntityS();
		this.result=new SimpleStringProperty("NULL");
		this.resultDescription= new SimpleStringProperty("NULL");
		this.tdCondition = new SimpleStringProperty("");
		this.isExpanded = new SimpleStringProperty("true");
		this.isBreak = new SimpleBooleanProperty();
		this.screenshot = new SimpleBooleanProperty(true);
		this.isSkip = new SimpleBooleanProperty();
		this.entityRef = new SimpleStringProperty();
	}



	public TestFolder(String firstName, String lastName) {
		this.objectName = new SimpleStringProperty(firstName);
		this.parameterValue = new SimpleStringProperty(lastName);

		// Some initial dummy data, just for convenient testing.
		this.actionMode = new SimpleStringProperty("some street");
		this.repetition = new SimpleStringProperty();
		this.dataType = new SimpleStringProperty("some city");
		this.jsonobject = new SimpleObjectProperty();
		this.parent = new SimpleObjectProperty();
		this.objectTreePath = new SimpleStringProperty("object Tree Path");
		this.thisStepTreePath = new SimpleStringProperty();
		this.objectType = new SimpleStringProperty("ojectType");
		children = FXCollections.observableArrayList();
		this.testFolderID = new SimpleStringProperty(this.hashCode() + "");
		this.entityS = new EntityS();
		this.result=new SimpleStringProperty("NULL");
		this.resultDescription= new SimpleStringProperty("NULL");
		this.tdCondition = new SimpleStringProperty("");
		this.isExpanded = new SimpleStringProperty("true");
		this.isBreak = new SimpleBooleanProperty();
		this.screenshot = new SimpleBooleanProperty(true);
		this.isSkip = new SimpleBooleanProperty();
		this.entityRef = new SimpleStringProperty();
	}

	public TestFolder(String objectName, String parameterValue, String actionMode, String repetition, String dataType,
			ObjectProperty jsonobject, String objectType, String objectTreePath) {
		super();
		this.objectName = new SimpleStringProperty(objectName);
		this.parameterValue = new SimpleStringProperty(parameterValue);
		this.actionMode = new SimpleStringProperty(actionMode);
		this.repetition = new SimpleStringProperty(repetition);
		this.dataType = new SimpleStringProperty(dataType);
		this.jsonobject = new SimpleObjectProperty();
		this.parent = new SimpleObjectProperty();
		this.objectType = new SimpleStringProperty(objectType);
		this.objectTreePath = new SimpleStringProperty(objectTreePath);
		this.thisStepTreePath = new SimpleStringProperty();
		children = FXCollections.observableArrayList();
		this.testFolderID = new SimpleStringProperty(this.hashCode() + "");
		this.entityS = new EntityS();
		this.result=new SimpleStringProperty("NULL");
		this.resultDescription= new SimpleStringProperty("NULL");
		this.isExpanded = new SimpleStringProperty("true");
		this.isBreak = new SimpleBooleanProperty();
		this.screenshot = new SimpleBooleanProperty(true);
		this.isSkip = new SimpleBooleanProperty();
		this.entityRef = new SimpleStringProperty();
		this.tdCondition = new SimpleStringProperty("");
		//this.breakCol = new SimpleBooleanProperty(true);
	}

	public TestFolder(String objectName, String parameterValue, String actionMode, String repetition, String dataType,
			String objectType, String objectTreePath) {
		super();
		this.objectName = new SimpleStringProperty(objectName);
		this.parameterValue = new SimpleStringProperty(parameterValue);
		this.actionMode = new SimpleStringProperty(actionMode);
		this.repetition = new SimpleStringProperty(repetition);
		this.dataType = new SimpleStringProperty(dataType);
		this.jsonobject = new SimpleObjectProperty();
		this.parent = new SimpleObjectProperty();
		this.objectType = new SimpleStringProperty(objectType);
		this.objectTreePath = new SimpleStringProperty(objectTreePath);
		this.thisStepTreePath = new SimpleStringProperty();
		children = FXCollections.observableArrayList();
		this.testFolderID = new SimpleStringProperty(this.hashCode() + "");
		this.entityS = new EntityS();
		this.result=new SimpleStringProperty("NULL");
		this.resultDescription= new SimpleStringProperty("NULL");
		this.tdCondition = new SimpleStringProperty("");
		this.isExpanded = new SimpleStringProperty("true");
		this.isBreak = new SimpleBooleanProperty();
		//this.breakCol = new SimpleBooleanProperty(true);
		this.screenshot = new SimpleBooleanProperty(true);
		this.isSkip = new SimpleBooleanProperty();
		this.entityRef = new SimpleStringProperty();
	}



	public  StringProperty entityRefProperty() {
		return this.entityRef;
	}


	public final String getEntityRef() {
		return entityRef.get();
	}


	public  void setEntityRef(String entityRef) {
		this.entityRef.set(entityRef);
	}

	public  BooleanProperty isSkipProperty() {
		return this.isSkip;
	}


	public final boolean getIsSkip() {
		return isSkip.get();
	}


	public  void setIsSkip(boolean isSkip) {
		this.isSkip.set(isSkip);
	}


	public  BooleanProperty screenshotProperty() {
		return this.screenshot;
	}


	public final boolean getScreenshot() {
		return screenshot.get();
	}


	public  void setScreenshot(boolean screenshot) {
		this.screenshot.set(screenshot);
	}


	public  BooleanProperty isBreakProperty() {
		return this.isBreak;
	}


	public final boolean getIsBreak() {
		return isBreak.get();
	}


	public  void setIsBreak(boolean isBreak) {
		this.isBreak.set(isBreak);
	}

	public  StringProperty isExpandedProperty() {
		return this.isExpanded;
	}


	public final String getIsExpanded() {
		return isExpanded.get();
	}


	public  void setIsExpanded(String isExpanded) {
		this.isExpanded.set(isExpanded);
	}

	public String getObjectName() {
		return objectName.get();
	}

	public void setObjectName(String firstName) {
		this.objectName.set(firstName);
	}

	public StringProperty objectNameProperty() {
		return objectName;
	}

	public String getParameterValue() {
		return parameterValue.get();
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue.set(parameterValue);
	}

	public StringProperty parameterValueProperty() {
		return parameterValue;
	}

	public String getActionMode() {
		return actionMode.get();
	}

	public void setActionMode(String actionMode) {

		this.actionMode.set(actionMode);
	}

	public StringProperty actionModeProperty() {
		return actionMode;
	}

	public String getRepetition() {
		return repetition.get();
	}

	public void setRepetition(String repetition) {
		this.repetition.set(repetition);
	}

	public StringProperty repetitionProperty() {
		return repetition;
	}

	public String getDataType() {
		return dataType.get();
	}

	public void setDataType(String city) {
		this.dataType.set(city);
	}

	public StringProperty dataTypeProperty() {
		return dataType;
	}

	/*@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getBirthday() {
		return birthday.get();
	}*/

	public void setBirthday(LocalDate birthday) {
		this.jsonobject.set(birthday);
	}

	public ObjectProperty<LocalDate> birthdayProperty() {
		return jsonobject;
	}

	public final StringProperty objectTypeProperty() {
		return this.objectType;
	}

	// @Override
	public final String getObjectType() {
		return this.objectTypeProperty().get();
	}

	public final void setObjectType(final String objectType) {
		this.objectTypeProperty().set(objectType);
	}

	public final StringProperty objectTreePathProperty() {
		return this.objectTreePath;
	}

	public final String getObjectTreePath() {
		return this.objectTreePathProperty().get();
	}

	public final void setObjectTreePath(final String objectTreePath) {
		this.objectTreePathProperty().set(objectTreePath);
	}


	public void addChild(TestFolder child){
		children.add(child);
		child.setParentTestFolder(this);
	}

	public void addChild(int index, TestFolder child){
		children.add(index, child);
		child.setParentTestFolder(this);
	}

	public void addChildren(ObservableList<TestFolder> children){
		this.children.addAll(children);
		for(int i=0;i<children.size();i++){
			children.get(i).setParentTestFolder(this);
		}
	}

	@XmlElement(name = "childern")
	public final ObservableList<TestFolder> getChildren() {
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

	/*
	 * public final IntegerProperty testFolderIDProperty() { return
	 * this.testFolderID; }
	 *
	 * @XmlID public final int getTestFolderID() { return
	 * this.testFolderIDProperty().get(); }
	 *
	 *
	 * public final void setTestFolderID(final int testFolderID) {
	 * this.testFolderIDProperty().set(testFolderID); }
	 */

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		/*return "TestFolder [objectName=" + objectName + ", parameterValue=" + parameterValue + ", actionMode="
				+ actionMode + ", repetition=" + repetition + ", dataType=" + dataType + ", birthday=" + birthday
				+ ", stepType=" + stepType + ", objectTreePath=" + objectTreePath + ", children=" + children
				+ ", objectFolder=" + objectFolder +  ", testFolderID=" + testFolderID +  "]";*/

		return objectName.get();
	}

	/**
	 * @param observable
	 * @see javafx.beans.property.Property#bind(javafx.beans.value.ObservableValue)
	 */
	public void bind(ObservableValue<? extends String> observable) {
		objectTreePath.bind(observable);
	}

	public final StringProperty testFolderIDProperty() {
		return this.testFolderID;
	}

	@XmlID
	public final String getTestFolderID() {
		return this.testFolderIDProperty().get();
	}

	public final void setTestFolderID(final String testFolderID) {
		if(this.testFolderID==null){
			this.testFolderID = new SimpleStringProperty();
		}
		this.testFolderIDProperty().set(testFolderID);
	}

	public TestFolder clone()  {
		try {
			/*TestFolder clonedTestFolder =(TestFolder) ObjectCloner.deepCopy(this);
			return clonedTestFolder;*/
			return (TestFolder) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public StringProperty resultProperty() {
		return this.result;
	}


	public String getResult() {
		return this.resultProperty().get();
	}


	public void setResult(final String result) {
		this.resultProperty().set(result);
	}


	public StringProperty resultDescriptionProperty() {
		return this.resultDescription;
	}


	public String getResultDescription() {
		return this.resultDescriptionProperty().get();
	}


	public void setResultDescription(final String resultDescription) {
		this.resultDescriptionProperty().set(resultDescription);
	}

	public final StringProperty tdConditionProperty() {
		return this.tdCondition;
	}


	public final String getTdCondition() {
		/*if(this.tdCondition.get()==null){
			this.tdCondition = new SimpleStringProperty("");
			//this.tdCondition.set("");
		}*/
		return this.tdConditionProperty().get();
	}


	public final void setTdCondition(final String tdCondition) {
		this.tdConditionProperty().set(tdCondition);
	}

	public StringProperty getThisStepTreePath() {
		return thisStepTreePath;
	}

	public final void setThisStepTreePath(final String thisStepTreePath) {
		this.thisStepTreePath.set(thisStepTreePath);
	}

	public StringProperty getNameProperty(){
		return this.objectName;
	}


	/*public TestFolder(Integer index, Object json, Object parent) {
        this.index = index;
        this.json = json;
        this.parent = new SimpleObjectProperty<>(parent);
    }

    public TestFolder(String key, Object json, Object parent) {
        this.key = key;
        this.json = json;
        this.parent = new SimpleObjectProperty<>(parent);
    }
    public TestFolder(String key) {
        this.key = key;
    }*/

    public boolean isJSONObject() {
        return json instanceof JSONObject;
    }

    public boolean isJSONArray() {
        return json instanceof JSONArray;
    }

    public JSONObject getJSONObject() {
        return (JSONObject) json;
    }
    public void setJSONObject(JSONObject json){
    	this.json = json;
    }

    public JSONArray getJSONArray() {
        return (JSONArray) json;
    }


    public void setKey(String key) {
        this.key = key;
    }

	/*public BooleanProperty getBreakCol() {
		return breakCol;
	}

	public void setBreakCol(boolean breakCol) {
		this.breakCol.set(breakCol);
	}*/



}