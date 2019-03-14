package com.cts.grizzlystore.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.grizzlystore.bean.Login;
import com.cts.grizzlystore.bean.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO{

	 @Autowired
	private SessionFactory sessionFactory;
	 
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(product);
		return "success";
	}

	

	public Product findProduct(String id) {
		// TODO Auto-generated method stub
		//String password = login.getPassword();
		
		Session session = sessionFactory.getCurrentSession();
		String query="from Product where productId = ?";
		Query<Product> query2 = null;
		
		query2= session.createQuery(query);
		
		query2.setParameter(0, id);
		//query2.setParameter(1, password);
		
		System.out.println("@");
		Product pro = query2.getSingleResult();
		return pro;
	}

	/*public String deleteProduct(String productId) {
		Product product = sessionFactory.getCurrentSession().load(Product.class, productId);
		sessionFactory.getCurrentSession().delete(product);
		return "success";
	}*/

	public List<Product> filterProducts(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return "success";
	}



	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		TypedQuery<Product> query = sessionFactory.getCurrentSession().createQuery("from Product");
		return query.getResultList();
	}



	@Override
	public void deleteProduct(String productId) {
		// TODO Auto-generated method stub
		Product product = sessionFactory.getCurrentSession().load(Product.class, productId);
		sessionFactory.getCurrentSession().delete(product);
		
		
		
		
	}
	
	

}
