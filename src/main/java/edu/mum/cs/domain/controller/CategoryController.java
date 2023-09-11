package edu.mum.cs.domain.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import edu.mum.cs.domain.Entity.Category;
import edu.mum.cs.domain.Entity.Product;
import edu.mum.cs.domain.Service.CategoryServiceImp;

public class CategoryController {
	
	private Scanner input = new Scanner(System.in);
	EntityManager entityManager;

	public CategoryController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	CategoryServiceImp categoryServiceImp=new CategoryServiceImp(entityManager);

	public void CategoryConsole() throws SQLException, ClassNotFoundException {
		System.out.println("  Add new Category Enter 1 : ");
		System.out.println("  Delete Category Enter 2 : ");
		System.out.println("  Select All Categorys Enter 3 :");
		System.out.println("  Select Category Enter 4 : ");

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
			System.out.println("************add new Category***************");
			Category category=new Category();
			System.out.println(" Enter id : ");
			category.setId(input.nextLong());
			System.out.println(" Enter Name : ");
			category.setName(input.next());
			System.out.println(" Enter Describtion : ");
			category.setDescribtion(input.next());
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
			category.setProducts(products);
			if (category.getId() != null) {
				category = entityManager.merge(category);
			} else
				categoryServiceImp.insert(category, entityManager);
		} catch (Exception e) {
			// System.out.println("Exception ya Esraa Fe el branch controller");
		}
	}

	public void delete(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		try {
			System.out.println("************* Delete Branch ***************");
			System.out.println("Enter id : ");
			Long id = input.nextLong();
			Category category=new Category();
			category.setId(id);
			System.out.println(entityManager);
			Category category2 = entityManager.find(Category.class, id);
			if (category2 != null) {
				categoryServiceImp.delete(category2, entityManager);
				System.out.println("Branch with id = " + category2.getId() + " is  Deleted ");
			} else {
				throw new EntityNotFoundException("Entity with ID " + id + " not found.");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public void selcetall(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		if (entityManager != null) {
			List<Category> categorys = categoryServiceImp.FindAll(entityManager);
			for (Category c : categorys) {
				System.out.println(c.getId() + " " + c.getName() + " " + c.getDescribtion());
			}
		}
	}

	public void select(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		System.out.println("Enter id : ");
		Long id = input.nextLong();
		Category category = categoryServiceImp.findById(id, entityManager);
		System.out.println(category.getId() + " " + category.getName());
	}
	

}
