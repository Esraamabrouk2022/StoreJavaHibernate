package edu.mum.cs.domain.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import edu.mum.cs.domain.Entity.Category;

public class CategoryDaoImp implements CategoryDao{

	EntityManager entityManager;

	public CategoryDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Category> FindAll(EntityManager entityManager) {

		return entityManager.createQuery("Select b From Category b", Category.class).getResultList();
	}

	@Override
	public Category findById(Long id,EntityManager entityManager) {

		Category Category = entityManager.find(Category.class, id);
		if (Category == null) {
			throw new EntityNotFoundException("Can't find Category for ID " + id);
		}
		return Category;
	}

	@Override
	public void insert(Category Category,EntityManager entityManager) {

		if (Category.getId()!=null) {
			Category = entityManager.merge(Category);
		} else
			entityManager.persist(Category);
	}

	@Override
	public void delete(Category Category,EntityManager entityManager) {
		entityManager.remove(Category);
	}
}
