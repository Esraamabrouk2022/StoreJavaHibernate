package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Dao.ZoneDaoImp;
import edu.mum.cs.domain.Entity.Zones;

public class ZoneServiceImp implements ZoneService {

	EntityManager entityManager;
	public ZoneServiceImp(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	ZoneDaoImp zoneDaoImp=new ZoneDaoImp(entityManager);

	@Override
	public List<Zones> FindAll(EntityManager entityManager) {
		return zoneDaoImp.FindAll(entityManager);
	}

	@Override
	public Zones findById(Long id,EntityManager entityManager) {

		return zoneDaoImp.findById(id,entityManager);
	}

	@Override
	public void insert(Zones zones,EntityManager entityManager) {
		zoneDaoImp.insert(zones,entityManager);
	}

	@Override
	public void delete(Zones zones,EntityManager entityManager) {
		zoneDaoImp.delete(zones,entityManager);
	}

}
