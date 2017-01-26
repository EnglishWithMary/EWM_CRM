package evg.testt.service;


import evg.testt.model.Note;

import java.sql.SQLException;

public interface NoteService {
    void insertNote(Note note) throws SQLException;
}
