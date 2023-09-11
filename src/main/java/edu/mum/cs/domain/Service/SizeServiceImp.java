package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Dao.SizeDaoImp;
import edu.mum.cs.domain.Entity.Sizes;

public class SizeServiceImp implements SizeService {
  
	EntityManager entityManager;
	public SizeServiceImp(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	SizeDaoImp sizeDaoImp=new SizeDaoImp(entityManager);
	@Override
	public List<Sizes> FindAll(EntityManager entityManager) {
		return sizeDaoImp.FindAll(entityManager);
	}

	@Override
	public Sizes findById(Long id,EntityManager entityManager) {
		return sizeDaoImp.findById(id,entityManager);
	}

	@Override
	public void insert(Sizes Sizes,EntityManager entityManager) {
		sizeDaoImp.insert(Sizes,entityManager);
	}

	@Override
	public void delete(Sizes Sizes,EntityManager entityManager) {
		sizeDaoImp.delete(Sizes,entityManager);
		
	}

}
