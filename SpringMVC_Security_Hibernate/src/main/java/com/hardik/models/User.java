package com.hardik.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	private String userName;
	
	private String password;
	
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(name="user_authority",
					joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="userId")},
					inverseJoinColumns={@JoinColumn(name="AUTHORITY_ID", referencedColumnName="id")})
	private Set<Authorities> authorities= new HashSet<Authorities>();
	
	private String userEmail;
	
	private String userAddress;
	
//	getter and setters
	public String getUserEmail() {		return userEmail;	}
	public void setUserEmail(String userEmail) {		this.userEmail = userEmail;	}
	public String getUserAddress() {		return userAddress;	}
	public void setUserAddress(String userAddress) {		this.userAddress = userAddress;	}
	public int getUserId() {		return userId;	}
	public void setUserId(int userId) {		this.userId = userId;	}
	public String getUserName() {		return userName;	}
	public void setUserName(String userName) {		this.userName = userName;	}
	public String getPassword() {		return password;	}
	public void setPassword(String password) {		this.password = password;	}
	public Set<Authorities> getAuthorities() {		return authorities;	}
	public void setAuthorities(Set<Authorities> authorities) {		this.authorities = authorities;	}
	
}
