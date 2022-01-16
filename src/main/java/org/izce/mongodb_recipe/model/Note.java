package org.izce.mongodb_recipe.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Note {
	private String Id;
	@NonNull
	private String note;
	
	@ToString.Exclude 
	@EqualsAndHashCode.Exclude
	private Recipe recipe;
}
