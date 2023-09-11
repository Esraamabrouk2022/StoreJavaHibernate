package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Dao.CityDaoImp;
import edu.mum.cs.domain.Entity.City;

public class CityServiceImp implements CityService{
   EntityManager entityManager;
	public CityServiceImp(EntityManager entityManager) {
	this.entityManager=entityManager;
	}
	CityDaoImp cityDaoImp= new CityDaoImp(entityManager); 
	@Override
	public List<City> FindAll(EntityManager entityManager){
		
		return cityDaoImp.FindAll( entityManager);
	}

	@Override
	public City findById(Long id,EntityManager entityManager) {
		
		return cityDaoImp.findById(id,entityManager);
	}

	@Override
	public void insert(City city,EntityManager entityManager) {
		cityDaoImp.insert(city,entityManager);
	}

	@Override
	public void delete(City city,EntityManager entityManager) {
		cityDaoImp.delete(city,entityManager);
	}

}
