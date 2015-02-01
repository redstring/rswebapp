package com.iredstring.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.iredstring.springmvc.model.RSUser;

@Repository("rsuserDao")
public class RSUserDaoImpl extends AbstractDao implements RSUserDao {

	@Override
	public void saveRSUser(RSUser rsuser) {
		persist(rsuser);
	}

	@Override
	public RSUser getRSUserByRsid(Long rsid) {
		Query query = getSession().createQuery(
				"FROM RSUser user WHERE user.rsid = " + rsid);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<RSUser> results = query.list();
		if (results.size() == 0)
			return null;
		return results.get(0);
	}

	@Override
	public RSUser getRSUserByUsername(String userName) {
		Query query = getSession().createQuery(
				"FROM RSUser user WHERE user.user_name = " + userName);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<RSUser> results = query.list();
		if (results.size() == 0)
			return null;
		return results.get(0);
	}

	@Override
	public List<RSUser> findAllRSUser() {
		Criteria criteria = getSession().createCriteria(RSUser.class);
		return (List<RSUser>) criteria.list();
	}

	@Override
	public void updateRSUser(RSUser rsuser){
		updateRSUserByRsid(rsuser.getRsid(), rsuser.getFbid(),rsuser.getMemberTypeId(),
				rsuser.getUserName(), rsuser.getUserEmail(), rsuser.getUserPassword(),
				rsuser.getNickname(), rsuser.getFirstName(), rsuser.getLastName(),
				rsuser.getPictureUrl(), rsuser.getPictureHeight(), rsuser.getPictureWidth());
	}

	@Override
	public void updateRSUserByRsid(Long rsid, Long fbid, Integer memberTypeId,
			String userName, String userEmail, String userPassword,
			String nickname, String firstName, String lastName,
			String pictureUrl, Integer pictureHeight, Integer pictureWidth) {
		Query query = getSession().createQuery("update RSUser set "
						+ " fbid = :fbid,"
						+ " member_type_id = :memberTypeId,"
						+ " user_name = :userName,"
						+ " user_email= :userEmail,"
						+ " user_password = :userPassword,"
						+ " nickname = :nickname,"
						+ " first_name = :firstName,"
						+ " last_name = :lastName,"
						+ " picture_url = :pictureUrl,"
						+ " picture_height = :pictureHeight,"
						+ " picture_width = :pictureWidth,"
						+ " where rsid = :rsid");
		query.setParameter("fbId", fbid);
		query.setParameter("memberTypeId", memberTypeId);
		query.setParameter("userName", userName);
		query.setParameter("userEmail", userEmail);
		query.setParameter("userPassword", userPassword);
		query.setParameter("nickname", nickname);
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		query.setParameter("pictureUrl", pictureUrl);
		query.setParameter("pictureHeight", pictureHeight);
		query.setParameter("pictureWidth", pictureWidth);
		int result = query.executeUpdate();
		

	}

}
