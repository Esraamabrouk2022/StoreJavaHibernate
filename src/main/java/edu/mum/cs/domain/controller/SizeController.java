package edu.mum.cs.domain.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import edu.mum.cs.domain.Entity.Sizes;
import edu.mum.cs.domain.Service.SizeServiceImp;

public class SizeController {
	
	private Scanner input = new Scanner(System.in);
	EntityManager entityManager;

	public SizeController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	SizeServiceImp sizeServiceImp=new SizeServiceImp(entityManager);

	public void BrandConsole() throws SQLException, ClassNotFoundException {
		System.out.println("  Add new Size Enter 1 : ");
		System.out.println("  Delete Size Enter 2 : ");
		System.out.println("  Select All Sizes Enter 3 :");
		System.out.println("  Select Size Enter 4 : ");

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
			System.out.println("************add new Size***************");
			Sizes size=new Sizes();
			System.out.println(" Enter id : ");
			size.setId(input.nextLong());
			System.out.println(" Enter Name : ");
			size.setName(input.next());
			
			if (size.getId() != null) {
				size = entityManager.merge(size);
			} else
				sizeServiceImp.insert(size, entityManager);
		} catch (Exception e) {
			// System.out.println("Exception ya Esraa Fe el branch controller");
		}
	}

	public void delete(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		try {
			System.out.println("************* Delete size ***************");
			System.out.println("Enter id : ");
			Long id = input.nextLong();
			Sizes size=new Sizes();
			size.setId(id);
			System.out.println(entityManager);
			Sizes size2 = entityManager.find(Sizes.class, id);
			if (size2 != null) {
				sizeServiceImp.delete(size2, entityManager);
				System.out.println("Branch with id = " + size2.getId() + " is  Deleted ");
			} else {
				throw new EntityNotFoundException("Entity with ID " + id + " not found.");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public void selcetall(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		if (entityManager != null) {
			List<Sizes> size = sizeServiceImp.FindAll(entityManager);
			for (Sizes b : size) {
				System.out.println(b.getId() + " " + b.getName() );
			}
		}
	}

	public void select(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		System.out.println("Enter id : ");
		Long id = input.nextLong();
		Sizes size = sizeServiceImp.findById(id, entityManager);
		System.out.println(size.getId() + " " + size.getName());
	}
    

}
