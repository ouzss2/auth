package com.mosofty.crm.mapper;

 
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.mosofty.crm.dto.UserView;
import com.mosofty.crm.model.User;
import com.mosofty.crm.repository.UserRepo;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class})
public abstract class UserViewMapper {

  @Autowired
  private UserRepo userRepo;

  public abstract UserView toUserView(User user);

  public abstract List<UserView> toUserView(List<User> users);

  public UserView toUserViewById(ObjectId id) {
    if (id == null) {
      return null;
    }
    return toUserView(userRepo.getById(id));
  }

}
