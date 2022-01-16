package org.izce.mongodb_recipe.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UnitOfMeasure {
	private String id;
	@NonNull
	private String uom;
}
