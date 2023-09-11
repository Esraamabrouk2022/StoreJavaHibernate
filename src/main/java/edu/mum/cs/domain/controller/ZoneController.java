package edu.mum.cs.domain.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import edu.mum.cs.domain.Entity.City;
import edu.mum.cs.domain.Entity.Zones;
import edu.mum.cs.domain.Service.ZoneServiceImp;

public class ZoneController {
	private Scanner input = new Scanner(System.in);
	EntityManager entityManager;

	public ZoneController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	ZoneServiceImp zoneServiceImp=new ZoneServiceImp(entityManager);

	public void BrandConsole() throws SQLException, ClassNotFoundException {
		System.out.println("  Add new zone Enter 1 : ");
		System.out.println("  Delete zone Enter 2 : ");
		System.out.println("  Select All zones Enter 3 :");
		System.out.println("  Select zone Enter 4 : ");

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
			System.out.println("************add new zone***************");
			Zones zone=new Zones();
			System.out.println(" Enter id : ");
			zone.setId(input.nextLong());
			System.out.println(" Enter Name : ");
			zone.setName(input.next());
			System.out.println(" Enter City id :");
			Long cityid=input.nextLong();
			City city=new City();
			city.setId(cityid);
			zone.setCity(city);
			if (zone.getId() != null) {
				zone = entityManager.merge(zone);
			} else
				zoneServiceImp.insert(zone, entityManager);
		} catch (Exception e) {
			// System.out.println("Exception ya Esraa Fe el branch controller");
		}
	}

	public void delete(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		try {
			System.out.println("************* Delete zone ***************");
			System.out.println("Enter id : ");
			Long id = input.nextLong();
			Zones zone =new Zones();
			zone.setId(id);
			System.out.println(entityManager);
			Zones zone2 = entityManager.find(Zones.class, id);
			if (zone2 != null) {
				zoneServiceImp.delete(zone2, entityManager);
				System.out.println("Branch with id = " + zone2.getId() + " is  Deleted ");
			} else {
				throw new EntityNotFoundException("Entity with ID " + id + " not found.");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public void selcetall(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		if (entityManager != null) {
			List<Zones> zone = zoneServiceImp.FindAll(entityManager);
			for (Zones b : zone) {
				System.out.println(b.getId() + " " + b.getName() );
			}
		}
	}

	public void select(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		System.out.println("Enter id : ");
		Long id = input.nextLong();
		Zones zone = zoneServiceImp.findById(id, entityManager);
		System.out.println(zone.getId() + " " + zone.getName());
	}
}
