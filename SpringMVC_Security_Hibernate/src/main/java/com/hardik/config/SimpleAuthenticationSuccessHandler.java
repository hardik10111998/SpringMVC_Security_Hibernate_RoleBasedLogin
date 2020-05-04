package com.hardik.config;

import java.io.IOException;
import java.util.Collection;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy= new DefaultRedirectStrategy();
	
	public void onAuthenticationSuccess(final HttpServletRequest arg0, final HttpServletResponse arg1, Authentication authentication)
			throws IOException, ServletException 
	{
		
		Collection<? extends GrantedAuthority> authorities= authentication.getAuthorities();
		
		authorities.forEach(new Consumer<GrantedAuthority>() 
		{
			
			public void accept(GrantedAuthority authority) 
			{
				if(authority.getAuthority().equals("ROLE_ADMIN"))
				{
					try
					{
						redirectStrategy.sendRedirect(arg0, arg1, "/admin/home");
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}else if(authority.getAuthority().equals("ROLE_USER"))
				{
					try
					{
						redirectStrategy.sendRedirect(arg0, arg1, "/user/home");
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		});

	}

}
