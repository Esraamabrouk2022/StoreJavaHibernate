package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Entity.Zones;

public interface ZoneService {
	List<Zones> FindAll(EntityManager entityManager);
	Zones findById(Long id,EntityManager entityManager);
	void insert(Zones zones,EntityManager entityManager);
	void delete(Zones zones,EntityManager entityManager);
}
