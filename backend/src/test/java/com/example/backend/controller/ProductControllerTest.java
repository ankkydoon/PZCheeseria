package com.example.backend.controller;

import com.example.backend.model.Product;
import com.example.backend.service.ProductService;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    @Test
    void save() {
        Product product = new Product();
        product.setTitle("Cheddar");
        product.setImgUrl("https://www.cheese.com/media/img/cheese/wiki/cheddar.jpg");
        product.setPrice(12D);
        product.setQuantity(0D);
        product.setTotal(0D);

        when(productService.save(any(Product.class))).thenReturn(product );

        Product responseEntity = productController.save(product);

        assertThat(responseEntity).isEqualTo(product);
    }

    @Test
    void update() {
        Product product = new Product();
        product.setTitle("Cheddar");
        product.setImgUrl("https://www.cheese.com/media/img/cheese/wiki/cheddar.jpg");
        product.setPrice(12D);
        product.setQuantity(0D);
        product.setTotal(0D);

        when(productService.updateById(any(long.class),any(Product.class))).thenReturn(product );

        Product responseEntity = productController.update(1L,product);

        assertThat(responseEntity).isEqualTo(product);
    }

    @Test
    void findAll() {
        Product product = new Product();
        product.setTitle("Cheddar");
        product.setImgUrl("https://www.cheese.com/media/img/cheese/wiki/cheddar.jpg");
        product.setPrice(12D);
        product.setQuantity(0D);
        product.setTotal(0D);

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        when(productService.findAll()).thenReturn(productList);

        List<Product> responseEntity = productController.findAll();

        assertThat(responseEntity).isEqualTo(productList);
    }

    @Test
    void findById() {
        Product product = new Product();
        product.setTitle("Cheddar");
        product.setImgUrl("https://www.cheese.com/media/img/cheese/wiki/cheddar.jpg");
        product.setPrice(12D);
        product.setQuantity(0D);
        product.setTotal(0D);


        when(productService.findById(any(Long.class))).thenReturn(product );

        Product responseEntity = productController.findById(1L);

        assertThat(responseEntity).isEqualTo(product);
    }

    @Test
    void deleteById() {
        Product product = new Product();
        product.setTitle("Cheddar");
        product.setImgUrl("https://www.cheese.com/media/img/cheese/wiki/cheddar.jpg");
        product.setPrice(12D);
        product.setQuantity(0D);
        product.setTotal(0D);

        //when(productService.deleteById(any(Long.class))).then(null);

        productController.deleteById(1L);
        verify(productService, times(1)).deleteById(any());
    }
}