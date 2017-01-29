package evg.testt.service.impl;

import evg.testt.dao.NoteRepository;
import evg.testt.model.Note;
import evg.testt.service.NoteService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class NoteServiceImpl extends BaseService<Note, NoteRepository> implements NoteService {
    @Override
    public void insertNote(Note note) throws SQLException {
        dao.saveNote(note);
    }
}
