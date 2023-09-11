package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Dao.BrandDaoImp;
import edu.mum.cs.domain.Entity.Brand;

public class BrandServiceImp implements BrandService{
	
	EntityManager entityManager;
	public BrandServiceImp(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	BrandDaoImp brandDaoImp=new BrandDaoImp(entityManager);

	@Override
	public List<Brand> FindAll(EntityManager entityManager) {
		
		return brandDaoImp.FindAll(entityManager);
	}

	@Override
	public Brand findById(Long id,EntityManager entityManager) {
		return brandDaoImp.findById(id,entityManager);
	}

	@Override
	public void insert(Brand brand,EntityManager entityManager) {
		brandDaoImp.insert(brand,entityManager);
	}

	@Override
	public void delete(Brand brand,EntityManager entityManager) {
		brandDaoImp.delete(brand,entityManager);
	}

	
	

}
