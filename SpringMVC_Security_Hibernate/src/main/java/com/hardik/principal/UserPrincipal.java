package com.hardik.principal;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hardik.models.Authorities;
import com.hardik.models.User;

public class UserPrincipal implements UserDetails {
	
	
	private static final long serialVersionUID = 1L;
	
	private User user;	

	public UserPrincipal(User user) {
		super();
		this.user = user;
	}

	

	@SuppressWarnings("unchecked")
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
//		String[] userAuthorities= user.getAuthorities().stream().map((a)->a.getAuthority()).toArray(String[]::new);
//		Collection<GrantedAuthority> authorities= AuthorityUtils.createAuthorityList(userAuthorities);
//		return authorities;
		
		return	(Collection<? extends GrantedAuthority>) user.getAuthorities().stream().map(new Function<Authorities, Object>() {
			public Object apply(Authorities authority) {
				return new SimpleGrantedAuthority(authority.getAuthority());
			}
		}).collect(Collectors.toList());
		
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
