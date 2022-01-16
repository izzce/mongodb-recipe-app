package org.izce.mongodb_recipe.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Ingredient {
	private String id;
	@NonNull
	private String description;
	@NonNull
	private BigDecimal amount;
	@NonNull
	private UnitOfMeasure uom;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Recipe recipe;

	public Ingredient(String description, float amount, UnitOfMeasure uom) {
		this(description, new BigDecimal(amount), uom);
	}
}
