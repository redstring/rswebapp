package com.iredstring.springmvc.service;

import java.util.List;

import com.iredstring.springmvc.model.RSUser;

public interface RSUserService {
	
	void saveRSUser(RSUser rsuser);
	
	RSUser getRSUserByRsid(Long rsid);
	
	RSUser getRSUserByUsername(String userName);

	List<RSUser> findAllRSUsers();

	void updateRSUser(RSUser rsuer);
	
	
	
}
