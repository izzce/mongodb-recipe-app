package org.izce.mongodb_recipe.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.izce.mongodb_recipe.model.UnitOfMeasure;
import org.izce.mongodb_recipe.repositories.UnitOfMeasureRepository;
import org.izce.mongodb_recipe.service.StorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
//
//@DataJpaTest
@SpringBootTest
@AutoConfigureTestDatabase
public class UnitOfMeasureRepositoryIT {
	
	@Autowired
	UnitOfMeasureRepository repository;
	
	@Autowired
	StorageService storageService;
	
	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testFindByUom() {
		Optional<UnitOfMeasure> uom = repository.findByUom("Teaspoon");
		
		assertEquals("Teaspoon", uom.get().getUom());
	}
	
	@Test
	public void testFindByUomCup() {
		Optional<UnitOfMeasure> uom = repository.findByUom("Cup");
		
		assertEquals("Cup", uom.get().getUom());
	}

}
