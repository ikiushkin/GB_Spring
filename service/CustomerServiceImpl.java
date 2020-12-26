package lesson_six.service;


import lesson_six.dao.CustomerDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final  CustomerDao customerDao;

    @Override
    @Transactional
    public void getCustomerProducts(int id) {
         customerDao.getCustomerProducts(id);
    }
}
