package com.example.GeneralStore.controller;

import com.example.GeneralStore.dto.ProductRequestDto;
import com.example.GeneralStore.entity.Product;
import com.example.GeneralStore.service.ProductService;
import com.example.GeneralStore.service.ShopOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private  final ShopOrderService shopOrderService;

    @PostMapping
    public Product createProduct(
           @Valid @RequestBody ProductRequestDto dto) {

        return productService.createProduct(dto);
    }


    @GetMapping("names")
    public List<String> getALLProductNames(){
        return  productService.getAllProductNames();
    }

    @GetMapping("/above-100")
    public List<Product> getProductAbove100(){
        return productService.getProductAbove100();
    }

    @GetMapping("/highest-price")
    public Product getHighestPriceProduct(){
        return productService.getAllHighestPriceProduct();
    }

    @GetMapping("/inventory-value")
    public Double getInventoryValue(){
        return  productService.getTotalInventoryValue();
    }

    @GetMapping("{id}")
    public  Product getProductById(
            @PathVariable Long id
    ){
        return  productService.findProduct(id);
    }

    @GetMapping("/top-selling-product")
    public String getTopSellingProduct() {

        return shopOrderService
                .getTopSellingProduct();
    }

    @GetMapping("/paginated")
    public Page<Product> getProducts(
          @RequestParam int page,
          @RequestParam int size){
        return productService.getProducts(page,size);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductByCategory(
            @PathVariable String category
    ){
        return productService.getProdoctsByCategory(category);
    }

    @GetMapping("/price-range")
    public List<Product> getProductsByPriceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice
    ){
        return  productService.getProductByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/search")
    public  List<Product> searchProducts(
            @RequestParam String keyword
    ){
        return productService.searchProduct(keyword);
    }

    @GetMapping("/above-price")
    public List<Product> getProductsAbovePrice(
            @RequestParam Double price) {

        return productService
                .getProductsAbovePrice(price);
    }

    @GetMapping("/test-rollback")
    public String testRollback(
            @RequestParam Long productId,
            @RequestParam Integer quantity) {

        return shopOrderService.placeOrder(
                productId,
                quantity
        );
    }

}