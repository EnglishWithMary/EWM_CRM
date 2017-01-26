package evg.testt.dao;

import evg.testt.model.Note;


public interface NoteRepository extends BaseRepository<Note> {
    void saveNote(Note note);
}
