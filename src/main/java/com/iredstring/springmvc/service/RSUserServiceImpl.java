package com.iredstring.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iredstring.springmvc.dao.RSUserDao;
import com.iredstring.springmvc.model.RSUser;

@Service("rsuserService")
@Transactional
public class RSUserServiceImpl implements RSUserService  {

	@Autowired
	private RSUserDao dao;
	
	@Override
	public void saveRSUser(RSUser rsuser) {
		dao.saveRSUser(rsuser);
	}		

	@Override
	public RSUser getRSUserByRsid(Long rsid){
		return dao.getRSUserByRsid(rsid);
	}
	
	@Override
	public RSUser getRSUserByUsername(String userName){
		return dao.getRSUserByUsername(userName);
	}

	
	@Override
	public List<RSUser> findAllRSUsers() {
		return dao.findAllRSUser();
	}

	@Override
	public void updateRSUser(RSUser rsuer) {
		dao.updateRSUser(rsuer);
	}
	

}
