package scom.project.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.repository.UserRepository;
import scom.project.api.repository.entity.UserEntity;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public String makeLogin(String login, String password) {
		UserEntity userEntity = userRepository.findUserDataByLogin(login);
		if (userEntity == null) {
			return null;
		} else {
			if(password.equals(userEntity.getPassword())) {
				return userEntity.getPermissionLevel();
			}
		}
		return null;
	}
}
