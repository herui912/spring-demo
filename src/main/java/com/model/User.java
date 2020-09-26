package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull(message="First name can not be null")
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull(message="Age can not be null")
	private Integer age;
	@NotNull
	private String country;

	public User () {
		super();
	}
	
	public User(String username, String password, String firstName, String lastName, Integer age, String country) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.country = country;
	}

	public Long getId() {
		return id;
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
	public String getFirstName () {
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		User user = (User) o;
		if (id == null) {
			if(user.id != null)
			return false;
		} else if (!id.equals(user.id))
			return false;
		if (username == null) {
			if(user.username != null)
			return false;
		} else if (!username.equals(user.username))
			return false;
		if (password == null) {
			if(user.password != null)
			return false;
		} else if (!password.equals(user.password))
			return false;
		if (firstName == null) {
			if(user.firstName != null)
			return false;
		} else if (!firstName.equals(user.firstName))
			return false;
		if (lastName == null) {
			if(user.lastName != null)
			return false;
		} else if (!lastName.equals(user.lastName))
			return false;
		if (age == null) {
			if(user.age != null)
			return false;
		} else if (!age.equals(user.age))
			return false;
		if (country == null) {
			if(user.country != null)
			return false;
		} else if (!country.equals(user.country))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", country=" + country;
	}


}
