package edu.mum.cs.domain.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Entity.Category;

public interface CategoryDao {
	List<Category> FindAll(EntityManager entityManager);
	Category findById(Long id,EntityManager entityManager);
	void insert(Category category,EntityManager entityManager);
	void delete(Category category,EntityManager entityManager);


}
