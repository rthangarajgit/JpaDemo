package com.example.JPADemo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;



import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EntityS {


	StringProperty entityid;
	ObservableList<EntityValue> colValues;
	ObservableList<Instance> instances;
	StringProperty type;
	StringProperty instanceType;
	StringProperty name;
	ObservableList<EntityS> childern;
	final BooleanProperty isExpanded;

	EntityS parentEntity;
	EntityS testCaseEntity;

	StringProperty parentEntityPath;

	EntityS entityRef;
	/*
	 * TreeTableView<Entity> entityTreeTableView =null;
	 *
	 * public TreeTableView<Entity> getEntityTreeTableView() { return
	 * entityTreeTableView; }
	 *
	 * public void setEntityTreeTableView(TreeTableView<Entity>
	 * entityTreeTableView) { this.entityTreeTableView = entityTreeTableView; }
	 */

	StringProperty treePath;

	public EntityS() {
		super();
		colValues = FXCollections.observableArrayList();
		instances = FXCollections.observableArrayList();
		childern = FXCollections.observableArrayList();
		this.type = new SimpleStringProperty();
		this.instanceType = new SimpleStringProperty();
		treePath = new SimpleStringProperty();
		this.name = new SimpleStringProperty("Dummy");
		entityid = new SimpleStringProperty(this.hashCode() + "");
		isExpanded = new SimpleBooleanProperty(true);
		parentEntityPath= new SimpleStringProperty();
	}




	public EntityS(String type) {
		super();
		colValues = FXCollections.observableArrayList();
		instances = FXCollections.observableArrayList();
		childern = FXCollections.observableArrayList();
		this.type = new SimpleStringProperty(type);
		this.instanceType = new SimpleStringProperty();
		treePath = new SimpleStringProperty();
		this.name = new SimpleStringProperty();
		entityid = new SimpleStringProperty();
		isExpanded = new SimpleBooleanProperty(true);
		parentEntityPath= new SimpleStringProperty();
	}

	public void addInstancesInEnity(EntityS instanceEntity) {
		if (this.getChildren() != null) {
			if (this.getChildren().size() > 0) {
				EntityS firstEntity = this.getChildren().get(0);
				if (!firstEntity.getType().equalsIgnoreCase("instances")) {
					EntityS instancesEntity = new EntityS("instances");
					instancesEntity.setName("instances");
					instanceEntity.setType("instance");
					this.getChildren().add(0, instancesEntity);
					instancesEntity.getChildren().add(instanceEntity);

				} else {
					instanceEntity.setType("instance");
					firstEntity.getChildren().add(instanceEntity);
				}
			} else {
				EntityS instancesEntity = new EntityS("instances");
				instancesEntity.setName("instances");
				instanceEntity.setType("instance");
				instancesEntity.getChildren().add(instanceEntity);
				this.getChildren().add(0, instancesEntity);

			}
		} else {
			EntityS instancesEntity = new EntityS("instances");
			instancesEntity.setName("instances");
			instanceEntity.setType("instance");
			this.getChildren().add(0, instancesEntity);
			instancesEntity.getChildren().add(instanceEntity);
		}
	}

	public void addInstances(EntityS instanceEntity) {
		if (this.getChildren() != null) {
			if (this.getChildren().size() > 0) {
				EntityS firstEntity = this.getChildren().get(0);
				if (!firstEntity.getType().equalsIgnoreCase("instances")) {
					EntityS instancesEntity = new EntityS("instances");
					instancesEntity.setName("instances");
					instanceEntity.setType("instance");
					this.getChildren().add(0, instancesEntity);
					instancesEntity.getChildren().add(instanceEntity);

				} else {
					instanceEntity.setType("instance");
					firstEntity.getChildren().add(instanceEntity);
				}
			} else {
				EntityS instancesEntity = new EntityS("instances");
				instancesEntity.setName("instances");
				instanceEntity.setType("instance");
				instancesEntity.getChildren().add(instanceEntity);
				this.getChildren().add(0, instancesEntity);

			}
		} else {
			EntityS instancesEntity = new EntityS("instances");
			instancesEntity.setName("instances");
			instanceEntity.setType("instance");
			this.getChildren().add(0, instancesEntity);
			instancesEntity.getChildren().add(instanceEntity);
		}
	}

	public void addColValues(EntityValue entityValue) {
		int index = 0;
		if (this.getColValues() != null) {
			this.getColValues().add(index, entityValue);
		} else {
			ObservableList<EntityValue> colValues = FXCollections.observableArrayList();
			colValues.add(index, entityValue);
			this.setColValues(colValues);
		}
	}

	public void addColValues(int index, EntityValue entityValue) {

		if (this.getColValues() != null) {
			this.getColValues().add(index, entityValue);
		} else {
			ObservableList<EntityValue> colValues = FXCollections.observableArrayList();
			colValues.add(index, entityValue);
			this.setColValues(colValues);
		}
	}

	/**
	 * @return the parentEntity
	 */
	@XmlIDREF
	public EntityS getParentEntity() {
		return parentEntity;
	}

	/**
	 * @return the testCaseEntity
	 */
	@XmlIDREF
	public EntityS getTestCaseEntity() {
		return testCaseEntity;
	}

	/**
	 * @param parentEntity
	 *            the parentEntity to set
	 */
	public void setParentEntity(EntityS parentEntity) {
		this.parentEntity = parentEntity;
	}

	/**
	 * @param testCaseEntity
	 *            the testCaseEntity to set
	 */
	public void setTestCaseEntity(EntityS testCaseEntity) {
		this.testCaseEntity = testCaseEntity;
	}

	/**
	 * @return the childern
	 */

	@XmlElement(name = "childern")
	public final ObservableList<EntityS> getChildren() {
		return childern;
	}

	/**
	 * @param childern
	 *            the childern to set
	 */
	public void setChildern(ObservableList<EntityS> childern) {
		this.childern = childern;
	}

	public EntityS(ObservableList<EntityValue> colValues, ObservableList<Instance> instances, String type) {
		super();
		this.colValues = colValues;
		this.instances = instances;
		this.type = new SimpleStringProperty(type);
		isExpanded = new SimpleBooleanProperty(true);
	}

	/**
	 * @return the colValues
	 */
	public ObservableList<EntityValue> getColValues() {
		return colValues;
	}

	/**
	 * @return the instances
	 */
	//@XmlElement(name = "instances")
	public ObservableList<EntityS> getInstances() {
		ObservableList<EntityS> instances = null;
		if (getChildren() != null && getChildren().size()!=0) {

			EntityS instances1 = getChildren().get(0);
			if (instances1.getType().equalsIgnoreCase("instances")) {

				if (instances1.getChildren()!=null) {
					instances = instances1.getChildren();
					/*for (int i = 0; i < instances1.getChildren().size(); i++) {

					}*/
				}

			}

		}
		return instances;

	}

	public ObservableList<String> getInstancesInStr() {
		ObservableList<EntityS> instances = null;
		ObservableList<String> strinstances = FXCollections.observableArrayList();
		if (getChildren() != null && getChildren().size()!=0) {

			EntityS instances1 = getChildren().get(0);
			if (instances1.getType().equalsIgnoreCase("instances")) {

				if (instances1.getChildren()!=null) {
					instances = instances1.getChildren();
					for (int i = 0; i < instances.size(); i++) {
						strinstances.add(instances.get(i).getName());

					}
				}

			}

		}
		return strinstances;

	}

	/**
	 * @param colValues
	 *            the colValues to set
	 */
	public void setColValues(ObservableList<EntityValue> colValues) {
		this.colValues = colValues;
	}

	/**
	 * @param instances
	 *            the instances to set
	 */
	public void setInstances(ObservableList<Instance> instances) {
		this.instances = instances;
	}

	public BooleanProperty isExpandedProperty() {
		return this.isExpanded;
	}

	public boolean getIsExpanded() {
		return this.isExpanded.get();
	}

	public void setIsExpanded(boolean isExpanded) {
		this.isExpanded.set(isExpanded);
	}

	public StringProperty typeProperty() {
		return this.type;
	}

	public String getType() {
		return this.typeProperty().get();
	}

	public void setType(final String type) {
		this.typeProperty().set(type);
	}

	public StringProperty parentEntityPathProperty() {
		return this.parentEntityPath;
	}

	public String getParentEntityPath() {
		try {
			return this.parentEntityPath.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setParentEntityPath(final String parentEntityPath) {
		if(this.parentEntityPath==null){
			this.parentEntityPath = new SimpleStringProperty(parentEntityPath);
		}
		this.parentEntityPath.set(parentEntityPath);
	}

	public StringProperty treePathProperty() {
		return this.treePath;
	}

	public String getTreePath() {
		return this.treePathProperty().get();
	}

	public void setTreePath(final String treePath) {
		if(this.treePath==null){
			this.treePath = new SimpleStringProperty(treePath);
		}
		this.treePathProperty().set(treePath);
	}

	public boolean isHasChildren() {
		if (getChildren().size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isEntity() {
		if (getChildren().size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public StringProperty nameProperty() {
		return this.name;
	}

	public String getName() {
		return this.nameProperty().get();
	}

	public void setName(final String name) {
		this.nameProperty().set(name);
	}

	@Override
	public String toString() {
		return name.get();
	}

	public StringProperty entityidProperty() {
		return this.entityid;
	}

	@XmlID
	public String getEntityid() {
		return this.entityidProperty().get();
	}

	public void setEntityid(final String entityid) {
		this.entityidProperty().set(entityid);
	}

	public void createEntityId() {

		setEntityid(this.hashCode() + "");
	}

	public EntityS getEntityByName(String name) {
		EntityS entityS = null;
		for (int i = 0; i < getChildren().size(); i++) {
			if (getChildren().get(i).getName().equalsIgnoreCase(name)) {
				return getChildren().get(i);
			}
		}
		return entityS;
	}

	public EntityS getEntityByName(String name, EntityS entityS) {

		for (int i = 0; i < entityS.getChildren().size(); i++) {
			try {
				// System.out.println(entity.getChildren().get(i).getName());
				// System.out.println(name);
				if (entityS.getChildren().get(i).getName().equalsIgnoreCase(name)) {
					// System.out.println(entity.getChildren().get(i).getColValues().get(0).getValue());
					return entityS.getChildren().get(i);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public EntityS getEntityByNames(String names) {
		EntityS entityS = this;
		if (names.contains(".")) {
			String[] arrNames = names.split("\\.");
			entityS = this;
			int increment = 0;
			for (String name : arrNames) {
				// System.out.println(entity.getName());
				if (increment != 0) {
					entityS = getEntityByName(name, entityS);
				} else {
					increment++;
				}
			}
		} else {
			entityS = getEntityByName(names, entityS);
		}

		return entityS;
	}

	public StringProperty instanceTypeProperty() {
		//System.out.println(instanceType);
		if(instanceType.get()==null){
			StringProperty newInstanceType = new SimpleStringProperty("");
			this.instanceType = newInstanceType;

		}
		return this.instanceType;
	}

	public String getInstanceType() {
		return this.instanceTypeProperty().get();
	}

	public void setInstanceType(final String instanceType) {
		this.instanceTypeProperty().set(instanceType);
	}

	public static class Typ {

        private final SimpleStringProperty typ;

        public Typ(String typ) {
            this.typ = new SimpleStringProperty(typ);
        }

        public String getTyp() {
            return this.typ.get();
        }

        public StringProperty typProperty() {
            return this.typ;
        }

        public void setTyp(String typ) {
            this.typ.set(typ);
        }

        @Override
        public String toString() {
            return typ.get();
        }

    }
	@XmlIDREF
	@XmlElement(name = "entityref")
	public EntityS getEntityRef() {
		return entityRef;
	}
	public void setEntityRef(EntityS entityRef) {
		this.entityRef = entityRef;
	}

}
