package evg.testt.dao.Jpa;

import evg.testt.dao.LanguageRepository;
import evg.testt.model.Language;
import org.springframework.stereotype.Repository;

@Repository
public class LanguageRepositoryJpaImpl extends BaseRepositoryJpaImpl<Language> implements LanguageRepository{
}
