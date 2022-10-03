package com.mosofty.crm.mapper;

 
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.mosofty.crm.dto.AuthorView;
import com.mosofty.crm.dto.UserView;
import com.mosofty.crm.model.Author;

import java.util.List;

@Mapper(componentModel = "spring", uses = ObjectIdMapper.class)
public abstract class AuthorViewMapper {

  private UserViewMapper userViewMapper;

  @Autowired
  public void setUserViewMapper(UserViewMapper userViewMapper) {
    this.userViewMapper = userViewMapper;
  }

  @Mapping(source = "creatorId", target = "creator", qualifiedByName = "idToUserView")
  public abstract AuthorView toAuthorView(Author author);

  public abstract List<AuthorView> toAuthorView(List<Author> authors);

  @Named("idToUserView")
  protected UserView idToUserView(ObjectId id) {
    return userViewMapper.toUserViewById(id);
  }
}
