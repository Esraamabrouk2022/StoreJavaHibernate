package edu.mum.cs.domain.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import edu.mum.cs.domain.Entity.Brand;

public class BrandDaoImp implements BrandDao {
	EntityManager entityManager;

	public BrandDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Brand> FindAll(EntityManager entityManager) {

		return entityManager.createQuery("Select b From Brand b", Brand.class).getResultList();
	}

	@Override
	public Brand findById(Long id,EntityManager entityManager) {

		Brand brand = entityManager.find(Brand.class, id);
		if (brand == null) {
			throw new EntityNotFoundException("Can't find Brand for ID " + id);
		}
		return brand;
	}

	@Override
	public void insert(Brand brand,EntityManager entityManager) {
		if (brand.getId()!=null) {
			brand = entityManager.merge(brand);
		} else
			entityManager.persist(brand);
	}

	@Override
	public void delete(Brand brand,EntityManager entityManager) {
		entityManager.remove(brand);
	}

}
