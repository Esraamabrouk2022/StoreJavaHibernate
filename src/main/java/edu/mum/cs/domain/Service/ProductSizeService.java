package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Entity.ProductSize;

public interface ProductSizeService {
	List<ProductSize> FindAll(EntityManager entityManager);
	ProductSize findById(Long id,EntityManager entityManager);
	void insert(ProductSize ProductSize,EntityManager entityManager);
	void delete(ProductSize ProductSize,EntityManager entityManager);

}
