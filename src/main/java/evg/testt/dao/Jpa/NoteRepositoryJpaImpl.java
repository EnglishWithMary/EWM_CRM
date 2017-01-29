package evg.testt.dao.Jpa;

import evg.testt.dao.NoteRepository;
import evg.testt.model.Note;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
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



