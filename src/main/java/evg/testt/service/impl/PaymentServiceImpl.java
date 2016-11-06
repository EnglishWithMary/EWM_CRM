package evg.testt.service.impl;

import evg.testt.dao.PaymentDao;
import evg.testt.model.Payment;
import evg.testt.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends BaseService<Payment, PaymentDao> implements PaymentService {

}