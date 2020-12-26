package lesson_six.service;

import lesson_six.dao.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Override
    @Transactional
    public void getProductCustomers(Long id) {
        productDao.getProductCustomers(id);
    }
}
