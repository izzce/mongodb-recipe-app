package org.izce.mongodb_recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DirectionCommand {
	private Long id;
	private String direction;
	private Long recipeId;
	
	public DirectionCommand(Long id, String direction) {
		this.id = id;
		this.direction = direction;
	}
}