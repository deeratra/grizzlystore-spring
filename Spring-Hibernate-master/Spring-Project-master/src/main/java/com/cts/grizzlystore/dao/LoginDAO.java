package com.cts.grizzlystore.dao;

import com.cts.grizzlystore.bean.Login;
//import com.grizzlystore.bean.Login;
public interface LoginDAO {
	
	
	public Login authenticate(Login login);
	public Login authenticateUserId(Login login);
	public void increaseAttempt(Login login);
	public void resetUserStatus(Login login);
	
	
}
