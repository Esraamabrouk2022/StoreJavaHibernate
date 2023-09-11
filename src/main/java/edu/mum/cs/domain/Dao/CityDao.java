package edu.mum.cs.domain.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Entity.City;

public interface CityDao {
	
	List<City> FindAll(EntityManager entityManager);
	City findById(Long id,EntityManager entityManager);
	void insert(City city,EntityManager entityManager);
	void delete(City city,EntityManager entityManager);


}
