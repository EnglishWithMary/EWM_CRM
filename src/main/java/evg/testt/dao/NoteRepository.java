package evg.testt.dao;

import evg.testt.model.Note;

import java.util.List;


public interface NoteRepository extends BaseRepository<Note> {
    void saveNote(Note note);

     List<Note> selectLastFiveNotes();

}
