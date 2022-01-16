package org.izce.mongodb_recipe.model;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Category {

	private String id;
	@NonNull
	private String description;
	
	@ToString.Exclude 
	@EqualsAndHashCode.Exclude 
	private Set<Recipe> recipes = new LinkedHashSet<Recipe>();

}
