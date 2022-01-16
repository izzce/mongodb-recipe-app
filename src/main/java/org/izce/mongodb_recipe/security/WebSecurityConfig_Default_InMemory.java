package org.izce.mongodb_recipe.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Profile("default")
public class WebSecurityConfig_Default_InMemory extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;

	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String encPwd = encoder.encode("pass");
		builder
			.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
			.withUser("izzet").password(encPwd).roles("USER").and()
			.withUser("elif").password(encPwd).roles("USER").and()
			.withUser("admin").password(encPwd).roles("ADMIN");
	}

	
 	@Override
 	public void configure(WebSecurity web) throws Exception {
 		// Spring Security should completely ignore URL matchers below
 		web.ignoring().antMatchers("/index", "/surprise", "/images/**", "/webjars/**", "/css/**", "/js/**", "/h2-console", "/h2-console/**");
 	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/recipe/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and()
			.formLogin().loginPage("/login").permitAll()
				.and()
			.logout().permitAll()
				.and()
			.requiresChannel().anyRequest().requiresSecure();
		
		
//		 The following part should be used as workaround to prevent 8080 to 8443 redirect. 
//		var portMapper = new PortMapperImpl();
//		portMapper.setPortMappings(Map.of("80", "443", "8080", "8080"));
//		var portResolver = new PortResolverImpl();
//		portResolver.setPortMapper(portMapper);
//		var entryPoint = new LoginUrlAuthenticationEntryPoint("/login");
//		entryPoint.setForceHttps(true);
//		entryPoint.setPortMapper(portMapper);
//		entryPoint.setPortResolver(portResolver);
//
//		http
//			.exceptionHandling().authenticationEntryPoint(entryPoint)
//				.and()
//			.authorizeRequests().antMatchers("/**").hasRole("USER")
//				.and()
//			.formLogin().loginPage("/login").permitAll()
//				.and()
//			.logout().permitAll()
//				.and()
//			.requiresChannel().anyRequest().requiresSecure();
	
	}

//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		//UserDetails user = User.withDefaultPasswordEncoder()
//		
//		//FIXME This seems to have no impact when this#configure(AuthenticationManagerBuilder builder)  
//		// is configured above. This maybe unnecessary. 
//		//PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		//String encPwd = encoder.encode("password");
//
//		//UserDetails admin1 = User.withUsername("admin").password(encPwd).roles("ADMIN").build();
//		//UserDetails user1 = User.withUsername("izzet").password(encPwd).roles("USER").build();
//		//UserDetails user2 = User.withUsername("elif").password(encPwd).roles("USER").build();
//		//return new InMemoryUserDetailsManager(admin1, user1, user2);
//		return new JdbcUserDetailsManager(dataSource);
//	}

}
