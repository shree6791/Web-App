package com.shree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shree.dao.LoginDao;
import com.shree.model.Login;

@Service
public class LoginServiceImpl implements LoginService {

	// need to inject login dao
	@Autowired
	private LoginDao loginDAO;
	
	@Override
	@Transactional
	public boolean getUser(String userName, String password) {
		return loginDAO.getUser(userName, password);
	}
	
}
