package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Dao.CategoryDaoImp;
import edu.mum.cs.domain.Entity.Category;

public class CategoryServiceImp implements CategoryService {
   
	EntityManager entityManager;
	
	public CategoryServiceImp(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	CategoryDaoImp categoryDaoImp=new CategoryDaoImp(entityManager);
	@Override
	public List<Category> FindAll(EntityManager entityManager) {
		return categoryDaoImp.FindAll(entityManager);
	}

	@Override
	public Category findById(Long id,EntityManager entityManager) {
		return categoryDaoImp.findById(id,entityManager);
	}

	@Override
	public void insert(Category category,EntityManager entityManager) {
		categoryDaoImp.insert(category,entityManager);
		
	}

	@Override
	public void delete(Category category,EntityManager entityManager) {
		categoryDaoImp.delete(category,entityManager);
		
	}

}
