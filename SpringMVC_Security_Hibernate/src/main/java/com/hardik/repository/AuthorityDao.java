package com.hardik.repository;

import com.hardik.models.Authorities;

public interface AuthorityDao {
	
	Authorities findByAuthorityName(String authority);

}
