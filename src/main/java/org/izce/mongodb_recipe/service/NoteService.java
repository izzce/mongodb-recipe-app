package org.izce.mongodb_recipe.service;

import org.izce.mongodb_recipe.commands.NoteCommand;
import org.izce.mongodb_recipe.model.Note;

public interface NoteService {
	Note findById(Long id);
	NoteCommand findNoteCommandById(Long id);
	NoteCommand saveNoteCommand(NoteCommand command);
	void delete(Long noteId);
}
