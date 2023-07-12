package com.mosofty.crm.mapper;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.mosofty.crm.dto.UserView;
import com.mosofty.crm.model.User;

@Configuration
public class UserViewMapper {

	public UserView toUserView(User user, String token) {
		return new UserView(user.getId(), user.getUsername(), user.getFullName(),user.getSurname(),user.getUfunction(), token);
	}
	public UserView toUserView(User user ) {
		return new UserView(user.getId(), user.getUsername(), user.getFullName(),user.getSurname(),user.getUfunction(),null);
	}

	public List<UserView> toUserView(List<User> users,String token) {
		return users.stream().map(user -> toUserView(user, token)).toList();
	}

	public List<UserView> toUserView(List<User> users ) {
		return users.stream().map(user -> toUserView(user)).toList();
	}
}
