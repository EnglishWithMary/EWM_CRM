package evg.testt.service.impl;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Language;
import evg.testt.model.Teacher;
import evg.testt.dao.TeacherRepository;
import evg.testt.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl extends RegisteredUserServiceImpl<Teacher, TeacherRepository> implements TeacherService {

    @Override
    public Teacher getUpdateTeacher(Teacher teacher, PersonDTO personDTO) throws ParseException {

        if (personDTO != null) {
            if (teacher == null) {
                teacher = new Teacher();
            }

            List<Language> languages = new ArrayList<>();

            for (String langName : personDTO.getLanguages()) {
                Language language = new Language();
                language.setLanguage(langName);
                languages.add(language);
            }
            teacher.setLanguages(languages);

        }
        return teacher;
    }
}