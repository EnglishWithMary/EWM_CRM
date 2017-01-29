package evg.testt.service;


import evg.testt.model.Note;

import java.sql.SQLException;

public interface NoteService extends Service<Note> {
    void insertNote(Note note) throws SQLException;
}
