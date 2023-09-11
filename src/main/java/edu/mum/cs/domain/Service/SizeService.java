/**
 * 
 */
package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Entity.Sizes;

public interface SizeService {
	List<Sizes> FindAll(EntityManager entityManager);
	Sizes findById(Long id,EntityManager entityManager);
	void insert(Sizes Sizes,EntityManager entityManager);
	void delete(Sizes Sizes,EntityManager entityManager);
}
