package edu.mum.cs.domain;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.mum.cs.domain.controller.CityController;

public class Main {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");

	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CityController cityController = new CityController(em);

		try {
			cityController.CityConsole();
			em.getTransaction().commit();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			em.close();
		}

	}
}
