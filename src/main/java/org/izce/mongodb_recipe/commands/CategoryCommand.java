package org.izce.mongodb_recipe.commands;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryCommand implements Serializable {
	private static final long serialVersionUID = 1185885918929722957L;
	
	private Long id;
    private String description;
    
    public CategoryCommand(String description) {
    	this.description = description;
    }
    
    public boolean exists() {
    	return id != null;
    }
    
    public Map<String, String> toMap() {
    	Map<String, String> result = new HashMap<>();
    	result.put("id", id == null ? "" : Long.toString(id));
    	result.put("description", description);
    	return result;
    }
    
    public String toJsonString(int index) {
    	StringBuilder sb = new StringBuilder("{ ");
    	sb.append("\"index\" : ").append(index);
    	sb.append(", \"id\" : ").append(id);
    	sb.append(", \"description\" : ").append('\"').append(description).append('\"');
    	return sb.toString();
    }
}