package edu.mum.cs.domain.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import edu.mum.cs.domain.Entity.Brand;
import edu.mum.cs.domain.Entity.Category;
import edu.mum.cs.domain.Entity.Product;
import edu.mum.cs.domain.Service.ProductServiceImp;

public class ProductController {

	
	private Scanner input = new Scanner(System.in);
	EntityManager entityManager;

	public ProductController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	ProductServiceImp productServiceImp=new ProductServiceImp(entityManager);

	public void BrandConsole() throws SQLException, ClassNotFoundException {
		System.out.println("  Add new Product Enter 1 : ");
		System.out.println("  Delete Product Enter 2 : ");
		System.out.println("  Select All Products Enter 3 :");
		System.out.println("  Select Product Enter 4 : ");

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
			System.out.println("************add new Product***************");
			Product product=new Product();
			System.out.println(" Enter id : ");
            product.setId(input.nextLong());
			System.out.println(" Enter Name : ");
			product.setName(input.next());
			System.out.println(" Enter Brand id: ");
			Long x=input.nextLong();
			Brand brand=new Brand();
			brand.setId(x);
			product.setBrand(brand);
			
			System.out.println(" Enter Category id: ");
			Long z=input.nextLong();
			Category category=new Category();
			category.setId(z);
			category.setId(x);
			product.setCategory(category);
			System.out.println(" Enter Description");
		    product.setDescriotion(input.next());
		    System.out.println(" Enter picture_path");
		    product.setPicture_path(input.next());
	
			if (product.getId() != null) {
				product = entityManager.merge(product);
			} else
				productServiceImp.insert(product, entityManager);
		} catch (Exception e) {
			// System.out.println("Exception ya Esraa Fe el branch controller");
		}
	}

	public void delete(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		try {
			System.out.println("************* Delete Branch ***************");
			System.out.println("Enter id : ");
			Long id = input.nextLong();
			Product product =new Product();
			product.setId(id);
			System.out.println(entityManager);
			Product product2 = entityManager.find(Product.class, id);
			if (product2 != null) {
				productServiceImp.delete(product2, entityManager);
				System.out.println("Branch with id = " + product2.getId() + " is  Deleted ");
			} else {
				throw new EntityNotFoundException("Entity with ID " + id + " not found.");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public void selcetall(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		if (entityManager != null) {
			List<Product> products = productServiceImp.FindAll(entityManager);
			for (Product b : products) {
				System.out.println(b.getId() + " " + b.getName());
			}
		}
	}

	public void select(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		System.out.println("Enter id : ");
		Long id = input.nextLong();
		Product product = productServiceImp.findById(id, entityManager);
		System.out.println(product.getId() + " " + product.getName());
	}
}
