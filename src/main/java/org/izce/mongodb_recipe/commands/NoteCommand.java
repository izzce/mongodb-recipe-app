package org.izce.mongodb_recipe.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteCommand {
	private Long id;
	private String note;
	private Long recipeId;
}