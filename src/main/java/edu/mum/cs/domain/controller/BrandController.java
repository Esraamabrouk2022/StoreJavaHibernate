package edu.mum.cs.domain.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import edu.mum.cs.domain.Entity.Brand;
import edu.mum.cs.domain.Entity.Product;
import edu.mum.cs.domain.Service.BrandServiceImp;

public class BrandController {
	private Scanner input = new Scanner(System.in);
	EntityManager entityManager;

	public BrandController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	BrandServiceImp brandServiceImp=new BrandServiceImp(entityManager);

	public void BrandConsole() throws SQLException, ClassNotFoundException {
		System.out.println("  Add new Brand Enter 1 : ");
		System.out.println("  Delete Brand Enter 2 : ");
		System.out.println("  Select All Brandes Enter 3 :");
		System.out.println("  Select Brand Enter 4 : ");

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
			System.out.println("************add new brand***************");
			Brand brand=new Brand();
			System.out.println(" Enter id : ");
			brand.setId(input.nextLong());
			System.out.println(" Enter Name : ");
			brand.setName(input.next());
			System.out.println(" Enter LogoPath : ");
			brand.setLogo_path(input.next());
			System.out.println(" Enter num of Products : ");
			int numofProducts=input.nextInt();
			List<Product>products=new ArrayList<Product>();
			for(int i=0;i<numofProducts;i++) {
				System.out.println("Enter productID :");
				Long idofProduct=input.nextLong();
				Product product=new Product();
				product.setId(idofProduct);
				products.add(product);
			}
			brand.setProducts(products);
			if (brand.getId() != null) {
				brand = entityManager.merge(brand);
			} else
				brandServiceImp.insert(brand, entityManager);
		} catch (Exception e) {
			// System.out.println("Exception ya Esraa Fe el branch controller");
		}
	}

	public void delete(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		try {
			System.out.println("************* Delete Branch ***************");
			System.out.println("Enter id : ");
			Long id = input.nextLong();
			Brand brand = new Brand();
			brand.setId(id);
			System.out.println(entityManager);
			Brand brand2 = entityManager.find(Brand.class, id);
			if (brand2 != null) {
				brandServiceImp.delete(brand2, entityManager);
				System.out.println("Branch with id = " + brand2.getId() + " is  Deleted ");
			} else {
				throw new EntityNotFoundException("Entity with ID " + id + " not found.");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public void selcetall(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		if (entityManager != null) {
			List<Brand> brands = brandServiceImp.FindAll(entityManager);
			for (Brand b : brands) {
				System.out.println(b.getId() + " " + b.getName() + " " + b.getLogo_path());
			}
		}
	}

	public void select(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		System.out.println("Enter id : ");
		Long id = input.nextLong();
		Brand brand = brandServiceImp.findById(id, entityManager);
		System.out.println(brand.getId() + " " + brand.getName());
	}

}
