package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Entity.Brand;

public interface BrandService {
	List<Brand> FindAll(EntityManager entityManager);
	Brand findById(Long id,EntityManager entityManager);
	void insert(Brand brand,EntityManager entityManager);
	void delete(Brand brand,EntityManager entityManager);
}
