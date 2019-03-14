package com.cts.grizzlystore.dao;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.event.TransactionPhase;

import com.cts.grizzlystore.bean.Login;

@Repository
@Transactional
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	
	public Login authenticate(Login login) {
		// TODO Auto-generated method stub
		try{
			String userName = login.getUserId();
			String password = login.getPassword();
			
			Session session = sessionFactory.getCurrentSession();
			String query="from Login where userId = ? and password = ?";
			Query<Login> query2 = null;
			
			query2= session.createQuery(query);
			
			query2.setParameter(0, userName);
			query2.setParameter(1, password);
			
			System.out.println("@");
			Login user= query2.getSingleResult();
			if(user!=null)
				return user;
			else
				 return null;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Login authenticateUserId(Login login) {
		// TODO Auto-generated method stub
		try{
			String userName = login.getUserId();
			//String password = login.getPassword();
			
			Session session = sessionFactory.getCurrentSession();
			String query="from Login where userId = ?";
			Query<Login> query2 = null;
			
			query2= session.createQuery(query);
			
			query2.setParameter(0, userName);
			//query2.setParameter(1, password);
			
			System.out.println("@");
			Login user= query2.getSingleResult();
			if(user!=null)
				return user;
			else
				 return null;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void increaseAttempt(Login login) {
		
		System.out.println("increase attempt function");
		login.setUserStatus(login.getUserStatus()+1);
		System.out.println(login.getUserStatus());
		sessionFactory.getCurrentSession().saveOrUpdate(login);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetUserStatus(Login login) {
		// TODO Auto-generated method stub
		System.out.println("reset function");
		login.setUserStatus(0);
		sessionFactory.getCurrentSession().saveOrUpdate(login);
		
	}
	


}
