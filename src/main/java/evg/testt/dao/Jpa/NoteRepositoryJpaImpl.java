package evg.testt.dao.Jpa;

import evg.testt.dao.NoteRepository;
import evg.testt.model.Note;


public class NoteRepositoryJpaImpl extends BaseRepositoryJpaImpl<Note> implements NoteRepository {
    @Override
    public void saveNote(Note note) {
//        if(note.getId() == null) {
//            em.persist(note);
//        }
//        else {
//            em.merge(note);
//        }
    }
}
