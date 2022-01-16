package org.izce.mongodb_recipe.bootstrap;

import org.izce.mongodb_recipe.model.Category;
import org.izce.mongodb_recipe.model.UnitOfMeasure;
import org.izce.mongodb_recipe.repositories.CategoryRepository;
import org.izce.mongodb_recipe.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Profile({ "dev", "prod" })
public class BootStrap_MariaDB implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepo;
	private final UnitOfMeasureRepository uomRepo;

	public BootStrap_MariaDB(CategoryRepository categoryRepo, UnitOfMeasureRepository uomRepo) {
		this.categoryRepo = categoryRepo;
		this.uomRepo = uomRepo;
		log.debug("Running BootStrap_MariaDB");
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		if (categoryRepo.count() == 0L) {
			log.debug("Loading Categories");
			loadCategories();
		}

		if (uomRepo.count() == 0L) {
			log.debug("Loading UOMs");
			loadUom();
		}
	}

	private void loadCategories() {
		categoryRepo.save(new Category("American"));
		categoryRepo.save(new Category("Italian"));
		categoryRepo.save(new Category("Mexican"));
		categoryRepo.save(new Category("Turkish"));
	}

	private void loadUom() {
		uomRepo.save(new UnitOfMeasure("Teaspoon"));
		uomRepo.save(new UnitOfMeasure("Tablespoon"));
		uomRepo.save(new UnitOfMeasure("Cup"));
		uomRepo.save(new UnitOfMeasure("Pinch"));
		uomRepo.save(new UnitOfMeasure("Ounce"));
		uomRepo.save(new UnitOfMeasure("Each"));
		uomRepo.save(new UnitOfMeasure("Pint"));
		uomRepo.save(new UnitOfMeasure("Dash"));
		uomRepo.save(new UnitOfMeasure("Goz karari"));
	}
}