package edu.mum.cs.domain.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import edu.mum.cs.domain.Entity.Zones;

public class ZoneDaoImp implements ZoneDao {

	EntityManager entityManager;

	public ZoneDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	@Override
	public List<Zones> FindAll(EntityManager entityManager) {
		return entityManager.createQuery("Select b From Zones b", Zones.class).getResultList();
	}

	@Override
	public Zones findById(Long id,EntityManager entityManager) {

		Zones Zones = entityManager.find(Zones.class, id);
		if (Zones == null) {
			throw new EntityNotFoundException("Can't find Zones for ID " + id);
		}
		return Zones;
	}

	@Override
	public void insert(Zones Zones,EntityManager entityManager) {
		if (Zones.getId() != null) {
			Zones = entityManager.merge(Zones);
		} else
			entityManager.persist(Zones);
	}

	@Override
	public void delete(Zones Zones,EntityManager entityManager) {
		entityManager.remove(Zones);
	}

}
