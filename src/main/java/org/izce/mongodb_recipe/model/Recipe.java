package org.izce.mongodb_recipe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	@OrderBy(value = "id") 
	@EqualsAndHashCode.Exclude 
	private List<Direction> directions = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	@OrderBy(value = "id") 
	@EqualsAndHashCode.Exclude 
	private List<Ingredient> ingredients = new ArrayList<>();
	@Lob
	private Byte[] image;
	private String imageUrl;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	@OrderBy(value = "id") 
	@EqualsAndHashCode.Exclude 
	private List<Note> notes = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "recipe_category", 
			joinColumns = @JoinColumn(name = "recipe_id"), 
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	@OrderBy(value = "id") 
	@EqualsAndHashCode.Exclude 
	private List<Category> categories = new ArrayList<>();

}
