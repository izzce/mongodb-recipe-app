package org.izce.mongodb_recipe.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		// izzetc: Alternatively, consider creating a LoginController to do this mapping. 
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/logout").setViewName("login?logout");
	}

}