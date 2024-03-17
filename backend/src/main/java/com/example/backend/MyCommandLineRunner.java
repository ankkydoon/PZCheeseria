package com.example.backend;

import com.example.backend.model.Product;
import com.example.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setTitle("Cheddar");
        product.setImgUrl("https://www.cheese.com/media/img/cheese/wiki/cheddar.jpg");
        product.setPrice(12D);
        product.setQuantity(0D);
        product.setTotal(0D);
        productService.save(product);

        Product product2 = new Product();
        product2.setTitle("American Cheese");
        product2.setImgUrl("https://www.cheese.com/media/img/cheese/10-American-Cheese-shutterstock_1610208106.jpg");
        product2.setPrice(11D);
        product2.setQuantity(0D);
        product2.setTotal(0D);
        productService.save(product2);

        Product product3 = new Product();
        product3.setTitle("Camembert");
        product3.setImgUrl("https://www.cheese.com/media/img/cheese-suggestion/CamembertStLoup_800x.jpg");
        product3.setPrice(13D);
        product3.setQuantity(0D);
        product3.setTotal(0D);
        productService.save(product3);

        Product product4 = new Product();
        product4.setTitle("Stilton");
        product4.setImgUrl("https://www.cheese.com/media/img/cheese-suggestion/Stilton_Range_Shot.jpg");
        product4.setPrice(14D);
        product4.setQuantity(0D);
        product4.setTotal(0D);
        productService.save(product4);

        Product product5 = new Product();
        product5.setTitle("Parmesan");
        product5.setImgUrl("https://www.cheese.com/media/img/cheese/parmesan_on_wooden_surface.jpg");
        product5.setPrice(15D);
        product5.setQuantity(0D);
        product5.setTotal(0D);
        productService.save(product5);
    }
}
