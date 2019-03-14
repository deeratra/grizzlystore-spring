package com.cts.grizzlystore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzlystore.bean.Login;
import com.cts.grizzlystore.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDAO loginDAO;

	@Override

	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS)
	public Login authenticate(Login login) {
		// TODO Auto-generated method stub
		return loginDAO.authenticate(login);
	}

	@Override
	public Login authenticateUserId(Login login) {
		// TODO Auto-generated method stub
		return loginDAO.authenticateUserId(login);
	}

	@Override
	public void increaseAttempt(Login login) {
		// TODO Auto-generated method stub
		System.out.println("^");
		 loginDAO.increaseAttempt(login);
		
	}

	@Override
	public void resetUserStatus(Login login) {
		// TODO Auto-generated method stub
		loginDAO.resetUserStatus(login);
		
	}
	
	
}
