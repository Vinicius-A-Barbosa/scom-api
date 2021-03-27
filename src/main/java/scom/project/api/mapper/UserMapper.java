package scom.project.api.mapper;

import scom.project.api.dto.UserDTO;
import scom.project.api.repository.entity.UserEntity;

public class UserMapper {
	
	public UserDTO convertUserEntityToDTO(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setLogin(userEntity.getLogin());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setPermissionLevel(userEntity.getPermissionLevel());
		return userDTO;
	}
}
