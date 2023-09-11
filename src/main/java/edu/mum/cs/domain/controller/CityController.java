package edu.mum.cs.domain.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import edu.mum.cs.domain.Entity.City;
import edu.mum.cs.domain.Service.CityServiceImp;

public class CityController {
	EntityManager entityManager;
	private Scanner input = new Scanner(System.in);
	public CityController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	CityServiceImp cityServiceImp=new CityServiceImp(entityManager);

	public void CityConsole() throws SQLException, ClassNotFoundException {
		System.out.println("  Add new City Enter 1 : ");
		System.out.println("  Delete City Enter 2 : ");
		System.out.println("  Select All Citys Enter 3 :");
		System.out.println("  Select City Enter 4 : ");

		switch (input.nextInt()) {
		case 1:
			this.insert(entityManager);
			break;
		case 2:
			this.delete(entityManager);
			break;
		case 3:
			this.selcetall(entityManager);
			break;
		case 4:
			this.select(entityManager);
			break;
		}

	}

	public void insert(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		try {
			System.out.println("************add new city***************");
			City city=new City();
			System.out.println(" Enter id : ");
			city.setId(input.nextLong());
			System.out.println(" Enter Name : ");
			city.setName(input.next());
			
			if (city.getId() != null) {
				city = entityManager.merge(city);
			} else
				cityServiceImp.insert(city, entityManager);
		} catch (Exception e) {
			// System.out.println("Exception ya Esraa Fe el branch controller");
		}
	}

	public void delete(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		try {
			System.out.println("************* Delete city ***************");
			System.out.println("Enter id : ");
			Long id = input.nextLong();
			City city=new City();
			city.setId(id);
			System.out.println(entityManager);
			City city2 = entityManager.find(City.class, id);
			if (city2 != null) {
				cityServiceImp.delete(city2, entityManager);
				System.out.println("Branch with id = " + city2.getId() + " is  Deleted ");
			} else {
				throw new EntityNotFoundException("Entity with ID " + id + " not found.");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public void selcetall(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		if (entityManager != null) {
			List<City> citys = cityServiceImp.FindAll(entityManager);
			for (City b : citys) {
				System.out.println(b.getId() + " " + b.getName() );
			}
		}
	}

	public void select(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		System.out.println("Enter id : ");
		Long id = input.nextLong();
		City city = cityServiceImp.findById(id, entityManager);
		System.out.println(city.getId() + " " + city.getName());
	}

}
