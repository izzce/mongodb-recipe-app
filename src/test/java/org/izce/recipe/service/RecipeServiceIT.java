package org.izce.recipe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.izce.mongodb_recipe.commands.RecipeCommand;
import org.izce.mongodb_recipe.converters.RecipeCommandToRecipe;
import org.izce.mongodb_recipe.converters.RecipeToRecipeCommand;
import org.izce.mongodb_recipe.model.Recipe;
import org.izce.mongodb_recipe.repositories.RecipeRepository;
import org.izce.mongodb_recipe.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RecipeServiceIT {

    public static final String NEW_DESCRIPTION = "New Description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Transactional
    @Test
    public void testSaveOfDescription() throws Exception {
        //given
        for (Recipe recipe : recipeRepository.findAll()) {
	        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);
	
	        //when
	        recipeCommand.setDescription(NEW_DESCRIPTION);
	        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(recipeCommand);
	
	        //then
	        assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription());
	        assertEquals(recipe.getId(), savedRecipeCommand.getId());
	        assertEquals(recipe.getCategories().size(), savedRecipeCommand.getCategories().size());
	        assertEquals(recipe.getIngredients().size(), savedRecipeCommand.getIngredients().size());
        }
    }
}