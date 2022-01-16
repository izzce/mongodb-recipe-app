package org.izce.mongodb_recipe.service;

import org.izce.mongodb_recipe.commands.DirectionCommand;
import org.izce.mongodb_recipe.model.Direction;

public interface DirectionService {
	Direction findById(Long id);
	DirectionCommand findDirectionCommandById(Long id);
	DirectionCommand saveDirectionCommand(DirectionCommand command);
	void delete(Long directionId);
}
