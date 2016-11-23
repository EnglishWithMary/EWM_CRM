package evg.testt.service.impl;

import evg.testt.model.Lead;
import evg.testt.repository.LeadRepository;
import evg.testt.service.LeadService;
import org.springframework.stereotype.Service;

@Service
public class LeadServiceImpl extends BaseService<Lead, LeadRepository> implements LeadService {

}