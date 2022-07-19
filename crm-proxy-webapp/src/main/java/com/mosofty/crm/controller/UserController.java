package com.mosofty.crm.controller;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mosofty.crm.model.AuthRegisterUser;

import com.mosofty.crm.model.RegisterUser;
import com.mosofty.crm.model.RegisterUserDto;

import com.mosofty.crm.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class UserController {
	@Autowired 
	PasswordEncoder encoder;
	@Autowired
	UserService userServices;
	
	
	
	@GetMapping("/get-users/{id}")
	public @ResponseBody RegisterUser getUser(@PathVariable("id")int id)
	{
		return userServices.getRUser(id);
	}
	
	@GetMapping("/GetUser") 
	public ResponseEntity<List<RegisterUser>> getuser() { 
		return ResponseEntity.ok(userServices.listRAll()); 
		}
	
	
		
	
	
	
	/*@PostMapping("/AddUser")
	public ResponseEntity<String> CreateUser(@RequestBody @Validated UserDto user) {
		User usertoadd = new User();
		 User user2 = new User();
		BeanUtils.copyProperties(user, usertoadd);
		 
		  user2 =userServices.getUserByMail(usertoadd.getEmail());

		    if(user2==null ) {
		    	usertoadd.setPassword(encoder.encode(usertoadd.getPassword()));
		    	userServices.save(usertoadd);
		    		return   ResponseEntity.ok().body("User Created!");
		    }
		return ResponseEntity.ok().body("User Already Existe !");
	}*/
	@PostMapping("/AddUser")
	public ResponseEntity<String> CreateUser(@RequestBody @Validated RegisterUserDto user) {
		System.out.println(user.toString());
		
		RegisterUser usertoadd = new RegisterUser();
		 RegisterUser user2 = new RegisterUser();
		BeanUtils.copyProperties(user, usertoadd);
		 
		  user2 =userServices.getRUserByMail(usertoadd.getEmail());

		    if(user2==null ) {
		    	usertoadd.setPassword(encoder.encode(usertoadd.getPassword()));
		    	userServices.Rsave(usertoadd);
		    		return   ResponseEntity.ok().body("User Created!");
		    }
		return ResponseEntity.ok().body("User Already Existe !");
	}

/*	@PostMapping("/Login")
	public ResponseEntity<Object> UserLogin(@RequestBody  @Validated UserDto user) {
		User usert = new User();
		System.out.print(usert.getPassword());
		BeanUtils.copyProperties(user, usert);
		  User user2 = new User();
		  user2 =userServices.getUserByMail(usert.getEmail());
		    if(user2!=null && encoder.matches(usert.getPassword(), user2.getPassword())  ) {
		    	String token = getJWTToken(user2.getFirstName());
		    		return  ResponseEntity.ok(new String(token));
		    }
		return ResponseEntity.ok(new String("Check Your Email And Your Password !"));
	            
	}*/
	@PostMapping("/Login")
	public ResponseEntity<JSONPObject> UserLogin(@RequestBody  @Validated RegisterUserDto user) {
		System.out.println(user.toString());
		RegisterUser usert = new RegisterUser();
		BeanUtils.copyProperties(user, usert);
		  RegisterUser user2 = new RegisterUser();
		  user2 =userServices.getRUserByMail(usert.getEmail());
		    if(user2!=null && encoder.matches(usert.getPassword(), user2.getPassword())  ) {
		    	String token = getJWTToken(user2.getFirstName());
		    		return  ResponseEntity.ok(new JSONPObject("Token", token));
		    }
		return ResponseEntity.ok(new JSONPObject("Error",new String("Check Your Email And Your Password !")));
	            
	}
	
	@PostMapping("/GetUserByMail")
	public ResponseEntity<Object> GetUser(@RequestBody RegisterUserDto user) {
		RegisterUser usert = userServices.getRUserByMail(user.getEmail());
	
		return ResponseEntity.ok(usert);
	            
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
		
		  try{
			  userServices.deleteR(id); 
			    return ResponseEntity.accepted().body("User Deleted !");        
			   }
			   catch (EmptyResultDataAccessException e){
			      return ResponseEntity.accepted().body("User Failed To be Deleted !");
			  } 
		  
	}
	
	@GetMapping("/user/{id}") 
	public ResponseEntity<String> getUserById (@PathVariable("id") int id)
	{
		
				RegisterUser user = new RegisterUser();		
			    user =userServices.getRUser(id); 
			    if (user==null) {
			    return ResponseEntity.ok().body("User not found !");        
			   }
		return ResponseEntity.ok().body("User exist");
			}
			  
	
		
	
	@PostMapping("/user")
	public AuthRegisterUser login(@RequestBody AuthRegisterUser userAuth) {
		AuthRegisterUser user = new AuthRegisterUser();
		String token = getJWTToken(userAuth.getFirstName());
		
		user.setToken(token);		
		return user;
		
	}

	
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return  token;
	}
		
	

	
	
	
}
	
	
