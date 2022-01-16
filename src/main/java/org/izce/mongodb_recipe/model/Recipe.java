package org.izce.mongodb_recipe.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
public class Recipe {
	private String id;
	@NonNull
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	private Difficulty difficulty;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude 
	private Byte[] image;
	private String imageUrl;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude 
	private List<Direction> directions = new ArrayList<>();

	@ToString.Exclude
	@EqualsAndHashCode.Exclude 
	private List<Ingredient> ingredients = new ArrayList<>();

	@ToString.Exclude
	@EqualsAndHashCode.Exclude 
	private List<Note> notes = new ArrayList<>();

	@ToString.Exclude
	@EqualsAndHashCode.Exclude 
	private List<Category> categories = new ArrayList<>();
}
