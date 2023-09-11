package edu.mum.cs.domain.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import edu.mum.cs.domain.Entity.Branch;

public class BranchDaoImp implements BranchDao {
	EntityManager entityManager;

	public BranchDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Branch> FindAll(EntityManager entityManager) {

		return entityManager.createQuery("Select b From Branch b", Branch.class).getResultList();
	}

	@Override
	public Branch findById(Long id,EntityManager entityManager) {

		Branch branch = entityManager.find(Branch.class, id);
		if (branch == null) {
			throw new EntityNotFoundException("Can't find branch for ID " + id);
		}
		return branch;
	}

	@Override
	public void insert(Branch branch,EntityManager entityManager) {

		if (branch.getId() != null) {
			branch = entityManager.merge(branch);
		} else
			entityManager.persist(branch);
	}

	@Override
	public void delete(Branch branch,EntityManager entityManager) {
		  Branch branch2=entityManager.find(Branch.class, branch.getId());
		 if(branch2!=null)
		 entityManager.remove(branch2);

	}

}
