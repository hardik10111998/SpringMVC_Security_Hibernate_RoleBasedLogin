package com.hardik.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@ComponentScan("com.hardik")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler; 
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	

//	  @Override
//	  protected void configure(HttpSecurity http) throws Exception {
//	    http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
//	    .and()
//	    .authorizeRequests().antMatchers("/login").permitAll()
//	    .and()
//	    .formLogin().loginPage("/login").loginProcessingUrl("/loginAction").permitAll()
//	    .and()
//	    .logout().logoutSuccessUrl("/login").permitAll()
//	    .and()
//	    .csrf().disable();
//	  }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/","/registration","/css/**").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/logout-success").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasRole("USER")
			.anyRequest().authenticated()
			.and()
			.formLogin().successHandler(successHandler)
			.loginPage("/login").permitAll()
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/logout-success").permitAll();			
			
	}
	

}
