package com.example.GeneralStore.controller;

import com.example.GeneralStore.dto.ProductRequestDto;
import com.example.GeneralStore.entity.Product;
import com.example.GeneralStore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product createProduct(
            @RequestBody ProductRequestDto dto) {

        return productService.createProduct(dto);
    }


    @GetMapping("names")
    public List<String> getALLProductNames(){
        return  productService.getAllProductNames();
    }
}