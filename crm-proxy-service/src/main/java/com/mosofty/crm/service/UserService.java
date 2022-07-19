package com.mosofty.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mosofty.crm.model.RegisterUser;

import com.mosofty.crm.repository.RUserRepository;




@Service
public class UserService {
	

	
	@Autowired
	RUserRepository repoR;


	public List<RegisterUser> listRAll(){
		return repoR.findAll();
	}
	
	

	public void Rsave( RegisterUser user) {
		repoR.save(user);
	}
	
	
	

	public RegisterUser getRUser(int id) { 
		
		return repoR.findById(id).orElse(null);
	}
	
	

	
	public RegisterUser getRUserByMail(String email) {
		return repoR.findUserByEmail(email);
	}
	
	
	

	public void deleteR(int id) {
		repoR.deleteById(id);
	
	}
	
}
