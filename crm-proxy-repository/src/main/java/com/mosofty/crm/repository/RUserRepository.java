package com.mosofty.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mosofty.crm.model.RegisterUser;

@Repository
public interface RUserRepository extends JpaRepository<RegisterUser, Integer>{
	
RegisterUser findUserByEmail(String email);

}
