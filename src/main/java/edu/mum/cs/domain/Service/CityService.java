package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Entity.City;

public interface CityService {
	List<City> FindAll(EntityManager entityManager);
	City findById(Long id,EntityManager entityManager);
	void insert(City city,EntityManager entityManager);
	void delete(City city,EntityManager entityManager);
}
