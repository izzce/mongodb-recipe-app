package org.izce.mongodb_recipe.service;

import java.util.List;

import org.izce.mongodb_recipe.commands.IngredientCommand;
import org.izce.mongodb_recipe.commands.UnitOfMeasureCommand;
import org.izce.mongodb_recipe.model.Ingredient;

public interface IngredientService {
	Ingredient findById(Long id);
	IngredientCommand findIngredientCommandById(Long id);
	IngredientCommand saveIngredientCommand(IngredientCommand command);
	UnitOfMeasureCommand findUom(String uom);
	UnitOfMeasureCommand findUom(Long uomId);
	List<UnitOfMeasureCommand> findAllUoms();
	void delete(Long ingredientId);
}
