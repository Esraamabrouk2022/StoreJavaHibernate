package edu.mum.cs.domain.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Entity.*;

public interface BranchDao {

	List<Branch> FindAll(EntityManager entityManager);
	Branch findById(Long id,EntityManager entityManager);
	void insert(Branch branch,EntityManager entityManager);
	void delete(Branch branch,EntityManager entityManager);

}
