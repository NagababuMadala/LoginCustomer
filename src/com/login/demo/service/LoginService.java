package com.login.demo.service;

public class LoginService {

	public boolean authenticateUserLogin(String userId,String password) {
		if (password == null|| password.trim()=="") {
			return false;
		}
		return true;
	}
}
