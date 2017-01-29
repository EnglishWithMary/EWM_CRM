package evg.testt.service.impl;

import evg.testt.dao.LanguageRepository;
import evg.testt.model.Language;
import evg.testt.service.LanguageService;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl extends BaseService<Language,LanguageRepository> implements LanguageService {
}
