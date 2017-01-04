package evg.testt.service.impl;

import evg.testt.dao.StudentLevelHistoryRepository;
import evg.testt.model.StudentLevelHistory;
import evg.testt.service.StudentLevelHistoryService;
import org.springframework.stereotype.Service;

@Service
public class StudentLevelHistoryServiceImpl extends BaseService<StudentLevelHistory, StudentLevelHistoryRepository> implements StudentLevelHistoryService {
}
