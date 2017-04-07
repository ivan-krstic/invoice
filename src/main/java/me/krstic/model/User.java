package me.krstic.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	private String username;
	private String password;
	private String name;
	private String role;
	private Integer status;
	@Temporal(TemporalType.DATE)
	private Date modifiedOn;
	
	public User() {
	}

	public User(String username, String password, String name, String role) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.role = role;
		this.status = 1;
		this.modifiedOn = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public String toString() {
		return "\"User\": {\n\t\"id\": \"" + id + "\",\n\t\"username\": \"" + username + "\",\n\t\"password\": \""
				+ password + "\",\n\t\"name\": \"" + name + "\",\n\t\"role\": \"" + role + "\",\n\t\"status\": \""
				+ status + "\",\n\t\"modifiedOn\": \"" + modifiedOn + "\"\n}";
	}
}
