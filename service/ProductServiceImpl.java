package Spring_L5.service;

import Spring_L5.dao.ProductDao;
import Spring_L5.entity.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Override
    @Transactional
    public List<Product> getProduct() {
        return productDao.getProduct();
    }

    @Override
    @Transactional
    public void saveOrUpdateCustomer(Product product) {
        productDao.saveOrUpdateProduct(product);
    }

    @Override
    @Transactional
    public Product getProduct(Long id) {
        return productDao.getProduct(id);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productDao.deleteProduct(id);
    }

    @Override
    @Transactional
    public List<Product> searchProduct(String theSearchTitle) {
        return productDao.searchProduct(theSearchTitle);
    }
}
