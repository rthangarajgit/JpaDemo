package com.example.JPADemo;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {


		EntityManagerFactory emf=Persistence.createEntityManagerFactory("TestFolder");
        EntityManager em=emf.createEntityManager();
        TestFolder newBufferItem = new TestFolder("New Buffer", "", "bufferitem", "1", "String", "bufferitem", "");
        em.persist(newBufferItem);
        em.getTransaction().commit();

        emf.close();
        em.close();
        //SpringApplication.run(JpaDemoApplication.class, args);
	}


	public static TestFolderListWrapper loadTestFolderFromFileObj(File file) {
		try {

			// File file = new File(currentPath + "/" + filename + ".xml");
			JAXBContext context = JAXBContext.newInstance(TestFolderListWrapper.class);
			Unmarshaller um = context.createUnmarshaller();
			TestFolderListWrapper wrapper = (TestFolderListWrapper) um.unmarshal(file);
			// System.out.println(wrapper.getTestFolders().get(0).getObjectName());
			return wrapper;
		} catch (Exception e) { // catches ANY exception
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not load data");
			alert.setContentText("Could not load data from file:\n" + file.getPath());
			alert.showAndWait();
		}
		return null;
	}


	public void loadXml(){
		TestFolderListWrapper wrapper = null;
		TestFolder testFolderData = null;
		ObjectFolder objectFolderData = null;
		File xmlFile = new File("");
		wrapper = loadTestFolderFromFileObj(xmlFile);
		testFolderData = wrapper.getTestFolders().get(0);
		objectFolderData = wrapper.getObjectFolders().get(0);


	}
}
