package com.cts.grizzlystore.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.cts.grizzlystore.bean.Category;


@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Category> getCategory() {
		

		TypedQuery<Category> query = sessionFactory.getCurrentSession().createQuery("from Category");
		List<Category> listss = query.getResultList();
		System.out.println(listss);
		// TODO Auto-generated method stub
		return listss;
	}


}
