package com.hardik.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table
public class Authorities {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String authority;
	
	@ManyToMany(mappedBy="authorities")
	private List<User> authorities;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public List<User> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<User> authorities) {
		this.authorities = authorities;
	}
	
}
