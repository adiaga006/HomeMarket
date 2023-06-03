package com.example.homemarket.facade;

import com.example.homemarket.dtos.ProductDTO;
import com.example.homemarket.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFacade {

    private final ProductService productService;

    public ProductFacade(ProductService productService) {
        this.productService = productService;
    }

    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    public ResponseEntity<List<ProductDTO>> getSearchProduct(String query) {
        return new ResponseEntity<>(productService.searchProducts(query), HttpStatus.OK);
    }

    public ResponseEntity<List<ProductDTO>> listProductByIds(List<Integer> ids) {
        List<ProductDTO> products = productService.listProductByCategories(ids);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
