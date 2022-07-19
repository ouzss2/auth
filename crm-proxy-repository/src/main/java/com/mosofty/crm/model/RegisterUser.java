package com.mosofty.crm.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonInclude;




@Entity
@Table(name="register")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "firstname", length = 80, nullable = false)
	private String firstName;
	
	@Column(name = "lastname", length = 80, nullable = false)
	private String lastName;
	
	@Column(name = "password", length = 80, nullable = false)
	private String password;
	
	@Column(name = "matchingPassword", length = 80, nullable = false)
	private String matchingPassword;
	
	
	@Column(name = "email", length = 80, nullable = false)
	private String email;
	
	@Column(name = "tel", length = 80, nullable = false)
	private String tel;
	
	@Column(name = "fax", length = 80, nullable = false)
	private String fax;
	
	
	
	@Column(name = "fix", length = 80, nullable = false)
	private String fix;

	@Column(name = "howcontact", length = 100, nullable = false)
	private String howcontact;
	
	@Column(name = "role", length = 80, nullable = false)
	private String role;
	
	@Column(name = "specialities")
	private int specialities;
	
	@Column(name = "adresse", length = 100, nullable = false)
	private String adresse;
	
	@Column(name = "lng", length = 100, nullable = false)
	private String lng;
	
	@Column(name = "lat", length = 100, nullable = false)
	private String lat;
	    
	@Column(name = "wherejob", length = 100, nullable = false)
	private String wherejob;

	@Column(name = "numeroPro", length = 100, nullable = false)
	private String numeroPro;
	
	@Column(name = "grade", length = 100, nullable = false)
	private int grade;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
	    return "Fname :"+getFirstName()+" Adresse:"+getAdresse()+" Email:"
				+getEmail()+" fax:"+getFax()+" fix:"+getFix()+" grade"
	    +getGrade()+" hoxContact:"+getHowcontact()+" id:"+getId()+" lastname:"
				+getLastName()+" MatchingPassword:"+getMatchingPassword()+" Pro"
	    +getNumeroPro()+" Password:"+getPassword()+" role:"
				+getRole()+" tel:"+getTel()+" Job:"+getWherejob()+"spes "+getSpecialities();
	}
	
	
	
	

	public RegisterUser() {
	}

	public RegisterUser(int id, String firstName, String lastName, String password, String matchingPassword,
			String email, String tel, String fax, String fix, String howcontact, String role, int specialities,
			String adresse, String lng, String lat, String wherejob, String numeroPro, int grade) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.email = email;
		this.tel = tel;
		this.fax = fax;
		this.fix = fix;
		this.howcontact = howcontact;
		this.role = role;
		this.specialities = specialities;
		this.adresse = adresse;
		this.lng = lng;
		this.lat = lat;
		this.wherejob = wherejob;
		this.numeroPro = numeroPro;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFix() {
		return fix;
	}

	public void setFix(String fix) {
		this.fix = fix;
	}

	public String getHowcontact() {
		return howcontact;
	}

	public void setHowcontact(String howcontact) {
		this.howcontact = howcontact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getWherejob() {
		return wherejob;
	}

	public void setWherejob(String wherejob) {
		this.wherejob = wherejob;
	}

	public String getNumeroPro() {
		return numeroPro;
	}

	public void setNumeroPro(String numeroPro) {
		this.numeroPro = numeroPro;
	}
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}





	public int getSpecialities() {
		return specialities;
	}





	public void setSpecialities(int specialities) {
		this.specialities = specialities;
	}
	
	


	
	
	

}
