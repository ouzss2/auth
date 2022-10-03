package com.mosofty.crm.mapper;

 
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.mosofty.crm.dto.EditAuthorRequest;
import com.mosofty.crm.model.Author;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", uses = ObjectIdMapper.class)
public interface AuthorEditMapper {

  Author create(EditAuthorRequest request);

  @BeanMapping(nullValueCheckStrategy = ALWAYS, nullValuePropertyMappingStrategy = IGNORE)
  void update(EditAuthorRequest request, @MappingTarget Author author);

}
