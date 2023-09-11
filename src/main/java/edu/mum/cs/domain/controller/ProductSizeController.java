package edu.mum.cs.domain.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import edu.mum.cs.domain.Entity.Product;
import edu.mum.cs.domain.Entity.ProductSize;
import edu.mum.cs.domain.Entity.Sizes;
import edu.mum.cs.domain.Service.ProductSizeServiceImp;

public class ProductSizeController {
	private Scanner input = new Scanner(System.in);
	EntityManager entityManager;

	public ProductSizeController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	ProductSizeServiceImp productSizeServiceImp=new ProductSizeServiceImp(entityManager);

	public void ProductSizeConsole() throws SQLException, ClassNotFoundException {
		System.out.println("  Add new ProductSize Enter 1 : ");
		System.out.println("  Delete ProductSize Enter 2 : ");
		System.out.println("  Select All ProductSizes Enter 3 :");
		System.out.println("  Select ProductSize Enter 4 : ");

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
			System.out.println("************add new ProductSize***************");
			ProductSize productSize=new ProductSize();
			System.out.println(" Enter id : ");
			productSize.setId(input.nextLong());
			System.out.println(" Enter Price : ");
			productSize.setPrice(input.nextFloat());
			System.out.println("Enter productID :");
			Long idofProduct=input.nextLong();
			Product product=new Product();
			product.setId(idofProduct);
			productSize.setProduct(product);
			
			System.out.println("Enter SizeID :");
			Long idofsize=input.nextLong();
			Sizes sizes=new Sizes();
			sizes.setId(idofsize);
			productSize.setSizes(sizes);
			
			if (productSize.getId() != null) {
				productSize = entityManager.merge(productSize);
			} else
				productSizeServiceImp.insert(productSize, entityManager);
		} catch (Exception e) {
			// System.out.println("Exception ya Esraa Fe el branch controller");
		}
	}

	public void delete(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		try {
			System.out.println("************* Delete productSize ***************");
			System.out.println("Enter id : ");
			Long id = input.nextLong();
			ProductSize productSize=new ProductSize();
			productSize.setId(id);
			System.out.println(entityManager);
			ProductSize productSize2= entityManager.find(ProductSize.class, id);
			if (productSize2 != null) {
				productSizeServiceImp.delete(productSize2, entityManager);
				System.out.println("productSize with id = " + productSize2.getId() + " is  Deleted ");
			} else {
				throw new EntityNotFoundException("Entity with ID " + id + " not found.");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public void selcetall(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		if (entityManager != null) {
			List<ProductSize> productSizes = productSizeServiceImp.FindAll(entityManager);
			for (ProductSize b : productSizes) {
				System.out.println(b.getId() + " " + b.getId() + " " + b.getPrice());
			}
		}
	}

	public void select(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		System.out.println("Enter id : ");
		Long id = input.nextLong();
		ProductSize productSize = productSizeServiceImp.findById(id, entityManager);
		System.out.println(productSize.getId() + " " + productSize.getPrice());
	}

}
