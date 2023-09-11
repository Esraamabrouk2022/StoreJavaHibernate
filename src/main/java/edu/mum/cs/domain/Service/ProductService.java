package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Entity.Product;

public interface ProductService {
	List<Product> FindAll(EntityManager entityManager);
	Product findById(Long id,EntityManager entityManager);
	void insert(Product Product,EntityManager entityManager);
	void delete(Product Product,EntityManager entityManager);

}
