package Spring_L5.main;

import Spring_L5.entity.Product;
import Spring_L5.service.ProductService;
import Spring_L5.service.ProductServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CrudApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
        ProductService productService = context.getBean("productServiceImpl", ProductServiceImpl.class);
        System.out.println(productService.getProduct());
        productService.saveOrUpdateCustomer(new Product("Asus",150000));
        System.out.println(productService.getProduct());
        productService.saveOrUpdateCustomer(new Product(6L,"Newspaper",100));
        System.out.println(productService.getProduct());
        System.out.println(productService.getProduct(4l));
        productService.deleteProduct(5L);
        System.out.println(productService.searchProduct("shoes"));
    }
}
