package edu.mum.cs.domain.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import edu.mum.cs.domain.Entity.ProductSize;

public class ProductSizeDaoImp  implements ProductSizeDao{

	EntityManager entityManager;

	public ProductSizeDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public List<ProductSize> FindAll(EntityManager entityManager) {
		return entityManager.createQuery("Select b From ProductSize b", ProductSize.class).getResultList();
	}
	@Override
	public ProductSize findById(Long id,EntityManager entityManager) {
		ProductSize ProductSize = entityManager.find(ProductSize.class, id);
		if (ProductSize == null) {
			throw new EntityNotFoundException("Can't find ProductSize for ID " + id);
		}
		return ProductSize;
	}

	@Override
	public void insert(ProductSize ProductSize,EntityManager entityManager) {
		if (ProductSize.getId() != null) {
			ProductSize = entityManager.merge(ProductSize);
		} else
			entityManager.persist(ProductSize);
		
	}

	@Override
	public void delete(ProductSize ProductSize,EntityManager entityManager) {
		entityManager.remove(ProductSize);	}

}
