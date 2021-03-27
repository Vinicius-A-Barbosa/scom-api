package scom.project.api.repository.impl;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.UserRepository;
import scom.project.api.repository.entity.UserEntity;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl implements UserRepository {
	
	@Override
	@Transactional
	public UserEntity findUserDataByLogin(String requiredLogin) {
		String queryText = "SELECT m FROM UserEntity m WHERE m.login = :requiredLogin";
		Query query = em.createQuery(queryText, UserEntity.class);
		query.setParameter("requiredLogin", requiredLogin);
		return (UserEntity) query.getSingleResult();
	}
}
