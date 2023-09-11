package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Dao.BranchDaoImp;
import edu.mum.cs.domain.Entity.Branch;

public class BranchServiceImp implements BranchService {
	EntityManager entityManager;
	public BranchServiceImp(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	BranchDaoImp branchDao=new BranchDaoImp(entityManager);
	@Override
	public List<Branch> FindAll(EntityManager entityManager) {

		return branchDao.FindAll(entityManager);
	}

	@Override
	public Branch findById(Long id,EntityManager entityManager) {
		return branchDao.findById(id,entityManager);
	}

	@Override
	public void insert(Branch branch,EntityManager entityManager) {
		System.out.println(entityManager+" service ");
		branchDao.insert(branch,entityManager);

	}

	@Override
	public void delete(Branch branch,EntityManager entityManager) {

		System.out.println(entityManager+" service ");
		Branch branch2=entityManager.find(Branch.class, branch.getId());
		if(branch2!=null)
		branchDao.delete(branch2,entityManager);
	}

}
