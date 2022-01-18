package org.izce.mongodb_recipe.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document
public class Note {
	
	@org.springframework.data.annotation.Id
	private String Id;
	@NonNull
	private String note;
	
	@ToString.Exclude 
	@EqualsAndHashCode.Exclude
	@DBRef
	private Recipe recipe;
}
