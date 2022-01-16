package org.izce.mongodb_recipe.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UnitOfMeasureCommand {
    private Long id;
    private String uom;
    
    public UnitOfMeasureCommand(String idText) {
    	this.id = Long.parseLong(idText);
    }
}