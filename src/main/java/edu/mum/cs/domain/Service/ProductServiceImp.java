package edu.mum.cs.domain.Service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.mum.cs.domain.Dao.ProductDaoImp;
import edu.mum.cs.domain.Entity.Product;

public class ProductServiceImp implements ProductService {

	EntityManager entityManager;
	public ProductServiceImp(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	ProductDaoImp productDaoImp=new ProductDaoImp(entityManager);

	@Override
	public List<Product> FindAll(EntityManager entityManager) {
		return productDaoImp.FindAll(entityManager);
	}

	@Override
	public Product findById(Long id,EntityManager entityManager) {

		return productDaoImp.findById(id,entityManager);
	}

	@Override
	public void insert(Product Product,EntityManager entityManager) {
		productDaoImp.insert(Product,entityManager);
	}

	@Override
	public void delete(Product Product,EntityManager entityManager) {
		productDaoImp.delete(Product,entityManager);
	}

}
