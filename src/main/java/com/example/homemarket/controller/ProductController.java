package com.example.homemarket.controller;

import com.example.homemarket.dtos.ProductDTO;
import com.example.homemarket.facade.ProductFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        return productFacade.getAllProduct();
    }

    @CrossOrigin
    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> getSearchProduct(@RequestParam("key") String query) {
        return productFacade.getSearchProduct(query);
    }

    @CrossOrigin
    @GetMapping("/productByCategory")
    public ResponseEntity<List<ProductDTO>> listProductByIds(@RequestParam("key") List<Integer> ids) {
        return productFacade.listProductByIds(ids);
    }
}
