package com.seniorsteps.app.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="FIRST_NAME")
	private String firstname;
	
	@Column(name="LAST_NAME")
	private String lastname;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="BIRTH_DATE")
	private LocalDate birthDate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="GENDER_ID")
	private Lookup gender;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TYPE_ID")
	private Lookup type;
	
	
	public User() {}
	
	public User(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Lookup getGender() {
		return gender;
	}
	public void setGender(Lookup gender) {
		this.gender = gender;
	}
	public Lookup getType() {
		return type;
	}
	public void setType(Lookup type) {
		this.type = type;
	}
	
}
