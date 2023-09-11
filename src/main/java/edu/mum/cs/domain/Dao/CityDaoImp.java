package edu.mum.cs.domain.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import edu.mum.cs.domain.Entity.City;

public class CityDaoImp implements CityDao {

	EntityManager entityManager;
	public CityDaoImp(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	@Override
	public List<City> FindAll(EntityManager entityManager) {
		return entityManager.createQuery("Select b From City b", City.class).getResultList();
	}

	@Override
	public City findById(Long id,EntityManager entityManager) {
		City city = entityManager.find(City.class, id);
		if (city == null) {
			throw new EntityNotFoundException("Can't find City for ID " + id);
		}
		return city;
	}

	@Override
	public void insert(City city,EntityManager entityManager) {
		if (city.getId() != null) {
			city = entityManager.merge(city);
		} else
			entityManager.persist(city);
	}

	@Override
	public void delete(City city,EntityManager entityManager) {
		entityManager.remove(city);
	}

}
