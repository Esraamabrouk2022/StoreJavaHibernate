package edu.mum.cs.domain.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import edu.mum.cs.domain.Entity.Product;

public class ProductDaoImp implements ProductDao {

	
	EntityManager entityManager;

	public ProductDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public List<Product> FindAll(EntityManager entityManager) {
		return entityManager.createQuery("Select b From Product b", Product.class).getResultList();
	}

	@Override
	public Product findById(Long id,EntityManager entityManager) {
		Product product = entityManager.find(Product.class, id);
		if (product == null) {
			throw new EntityNotFoundException("Can't find product for ID " + id);
		}
		return product;
	}

	@Override
	public void insert(Product Product,EntityManager entityManager) {
		if (Product.getId() != null) {
			Product = entityManager.merge(Product);
		} else
			entityManager.persist(Product);
	}

	@Override
	public void delete(Product Product,EntityManager entityManager) {
		entityManager.remove(Product);
		
	}

}
