package org.izce.mongodb_recipe;

import org.izce.mongodb_recipe.formatters.CategoryFormatter;
import org.izce.mongodb_recipe.formatters.IngredientFormatter;
import org.izce.mongodb_recipe.service.StorageProperties;
import org.izce.mongodb_recipe.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MongoDbRecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbRecipeApplication.class, args);
	}

    @Configuration
    static class RecipeAppConfig implements WebMvcConfigurer {
        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addFormatter(new CategoryFormatter());
            registry.addFormatter(new IngredientFormatter());
        }
    }
    
    @Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
