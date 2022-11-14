package com.mosofty.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.mosofty.crm.dto.RoleView;


@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

  private static final long serialVersionUID = 1L;
  public static final String USER_ADMIN = "USER_ADMIN";
  public static final String AUTHOR_ADMIN = "AUTHOR_ADMIN";
  public static final String BOOK_ADMIN = "BOOK_ADMIN";
 
  public Role(String authority)
  {
	  this.authority=authority;
  }
  
  public Role(RoleView roleView)
  {
	  this.id= roleView.id();
	  this.authority= roleView.authority();
  }
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String authority;

}
