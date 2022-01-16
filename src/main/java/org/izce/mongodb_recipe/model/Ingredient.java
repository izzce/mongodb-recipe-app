package org.izce.mongodb_recipe.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@ToString
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;

	@OneToOne
	private UnitOfMeasure uom;

	@ToString.Exclude
	@ManyToOne
	private Recipe recipe;

	public Ingredient(String description, float amount, UnitOfMeasure uom) {
		this.description = description;
		this.amount = new BigDecimal(amount);
		this.uom = uom;
	}
}
