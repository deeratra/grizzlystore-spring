package com.cts.grizzlystore.service;

import com.cts.grizzlystore.bean.Login;
//import com.grizzlystore.bean.Profile;


public interface LoginService {
	
	
	public Login authenticate(Login login);
	public Login authenticateUserId(Login login);
	public void increaseAttempt(Login login);
	public void resetUserStatus(Login login);
	
	
}
