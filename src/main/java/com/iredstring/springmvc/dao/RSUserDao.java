package com.iredstring.springmvc.dao;

import java.util.List;

import com.iredstring.springmvc.model.RSUser;

public interface RSUserDao {

	void saveRSUser(RSUser rsuser);
	
	RSUser getRSUserByRsid(Long rsid);
	
	RSUser getRSUserByUsername(String userName);

	List<RSUser> findAllRSUser();

	void updateRSUser(RSUser rsuer);

	void updateRSUserByRsid(Long rsid, Long fbid, Integer memberTypeId, String userName, String userEmail,
			String userPassword, String nickname, String firstName, String lastName,
			String pictureUrl, Integer pictureHeight, Integer pictureWidth);
}
