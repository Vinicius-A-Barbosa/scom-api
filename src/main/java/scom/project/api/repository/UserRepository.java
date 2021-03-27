package scom.project.api.repository;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.UserEntity;

@Repository
public interface UserRepository extends BaseRepository {
	public UserEntity findUserDataByLogin(String requiredLogin);
}
