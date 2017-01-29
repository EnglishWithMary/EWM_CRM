package evg.testt.dao.Jpa;

import evg.testt.dao.NoteRepository;
import evg.testt.model.Note;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class NoteRepositoryJpaImpl extends BaseRepositoryJpaImpl<Note> implements NoteRepository {
    @Override
    public void saveNote(Note note) {
    }

    public List<Note> selectLastFiveNotes(){
        query = em.createQuery("SELECT manager FROM managers manager WHERE user_id =:id");
    }
}



