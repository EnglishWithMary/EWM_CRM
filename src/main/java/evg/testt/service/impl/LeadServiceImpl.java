package evg.testt.service.impl;

import evg.testt.model.Lead;
import evg.testt.repository.LeadRepository;
import evg.testt.service.LeadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LeadServiceImpl extends BaseService<Lead, LeadRepository> implements LeadService {
}