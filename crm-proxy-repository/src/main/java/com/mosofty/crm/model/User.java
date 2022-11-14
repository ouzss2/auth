package com.mosofty.crm.model;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
 
import org.springframework.data.annotation.LastModifiedDate;
 
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 

@Entity
@Table(name = "users")
@Getter @Setter
public class User  implements UserDetails {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;

  @CreatedDate
  private LocalDateTime createdAt;
  @LastModifiedDate
  private LocalDateTime modifiedAt;

  private boolean enabled = true;

 
  private String username;
  private String password;

  private String fullName;
  @ManyToMany(cascade = { CascadeType.MERGE})
  @JoinTable(
      name = "user_roles", 
      joinColumns = { @JoinColumn(name = "user_id") }, 
      inverseJoinColumns = { @JoinColumn(name = "role_id") }
  )
  private List<Role> authorities = new ArrayList<>();

  public User() {
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return enabled;
  }

  @Override
  public boolean isAccountNonLocked() {
    return enabled;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return enabled;
  }
}
