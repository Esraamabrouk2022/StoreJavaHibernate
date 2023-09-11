package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Dao.ProductSizeDaoImp;
import edu.mum.cs.domain.Entity.ProductSize;

public class ProductSizeServiceImp implements ProductSizeService {

	EntityManager entityManager;
	public ProductSizeServiceImp(EntityManager entityManager){
		this.entityManager=entityManager;
	}
	ProductSizeDaoImp productSizeDaoImp=new ProductSizeDaoImp(entityManager);

	@Override
	public List<ProductSize> FindAll(EntityManager entityManager) {
		return productSizeDaoImp.FindAll(entityManager);
	}

	@Override
	public ProductSize findById(Long id,EntityManager entityManager) {
		return productSizeDaoImp.findById(id, entityManager);
	}

	@Override
	public void insert(ProductSize ProductSize,EntityManager entityManager) {
		productSizeDaoImp.insert(ProductSize,entityManager);
	}

	@Override
	public void delete(ProductSize ProductSize,EntityManager entityManager) {
		productSizeDaoImp.delete(ProductSize,entityManager);
	}

}
