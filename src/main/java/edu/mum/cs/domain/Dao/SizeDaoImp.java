package edu.mum.cs.domain.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import edu.mum.cs.domain.Entity.Sizes;

public class SizeDaoImp implements SizeDao {

	EntityManager entityManager;

	public SizeDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Sizes> FindAll(EntityManager entityManager) {
		return entityManager.createQuery("Select b From Sizes b", Sizes.class).getResultList();
	}

	@Override
	public Sizes findById(Long id,EntityManager entityManager) {
		Sizes Sizes = entityManager.find(Sizes.class, id);
		if (Sizes == null) {
			throw new EntityNotFoundException("Can't find Sizes for ID " + id);
		}
		return Sizes;
	}

	@Override
	public void insert(Sizes Sizes,EntityManager entityManager) {
		if (Sizes.getId() != null) {
			Sizes = entityManager.merge(Sizes);
		} else
			entityManager.persist(Sizes);
		
	}

	@Override
	public void delete(Sizes Sizes,EntityManager entityManager) {
		entityManager.remove(Sizes);
		
	}

}
