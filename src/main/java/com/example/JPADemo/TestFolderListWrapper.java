package com.example.JPADemo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.JPADemo.ObjectFolder;
import com.example.JPADemo.EntityS;

/**
 * Helper class to wrap a list of persons. This is used for saving the list of
 * persons to XML.
 * 
 * @author Marco Jakob
 */
@XmlRootElement(name = "testfolders")
public class TestFolderListWrapper {

	int lastTestFolderId;
	int lastObjectId;

	private List<TestFolder> testfolders;
	private List<ObjectFolder> objectfolders;
	private List<EntityS> entitySs;

	

	/**
	 * @return the entities
	 */
	@XmlElement(name = "entity")
	public List<EntityS> getEntities() {
		return entitySs;
	}

	/**
	 * @param entitySs the entities to set
	 */
	public void setEntities(List<EntityS> entitySs) {
		this.entitySs = entitySs;
	}

	@XmlElement(name = "testfolder")
	public List<TestFolder> getTestFolders() {
		return testfolders;
	}

	public void setTestFolders(List<TestFolder> testfolders) {
		this.testfolders = testfolders;
	}

	@XmlElement(name = "objectfolder")
	public List<ObjectFolder> getObjectFolders() {
		return objectfolders;
	}

	public void setObjectFolders(List<ObjectFolder> objectfolders) {
		this.objectfolders = objectfolders;
	}

}