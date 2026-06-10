package com.example.GeneralStore.service;

import com.example.GeneralStore.dto.ProductRequestDto;
import com.example.GeneralStore.entity.Product;
import com.example.GeneralStore.entity.ShopOrder;
import com.example.GeneralStore.exception.ResourceNotFoundException;
import com.example.GeneralStore.mapper.ProductMapper;
import com.example.GeneralStore.repository.ProductRepository;
import com.example.GeneralStore.repository.ShopOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ShopOrderRepository shopOrderRepository;
    private final ProductMapper productMapper;

    public ProductRequestDto createProduct(
            ProductRequestDto dto
    ) {

        Product product = Product.builder()
                .productName(dto.getProductName())
                .price(dto.getPrice())
                .stockQuantity(dto.getStockQuantity())
                .category(dto.getCategory())
                .build();

        Product savedProduct =
                productRepository.save(product);

        return productMapper.toDto(savedProduct);
    }

    public List<String> getAllProductNames() {

        return productRepository.findAll()
                .stream()
                .map(Product::getProductName)
                .toList();
    }

    public Product getAllHighestPriceProduct() {

        return productRepository.findAll()
                .stream()
                .max(Comparator.comparing(Product::getPrice))
                .orElse(null);
    }

    public List<Product> getProductAbove100() {

        return productRepository.findAll()
                .stream()
                .filter(product ->
                        product.getPrice() > 100)
                .toList();
    }

    public Double getTotalInventoryValue() {

        return productRepository.findAll()
                .stream()
                .mapToDouble(
                        p -> p.getPrice()
                                * p.getStockQuantity()
                )
                .sum();
    }

    public Product findProduct(Long id) {

        return productRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                "Product Not Found"
                        )
                );
    }

    public String getTopSellingProduct() {

        return shopOrderRepository.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                o -> o.getProduct()
                                        .getProductName(),
                                Collectors.summingInt(
                                        ShopOrder::getQuantity
                                )
                        )
                )
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No Orders");
    }

    public Page<Product> getProducts(
            int page,
            int size
    ) {

        Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        Sort.by("price")
                                .descending()
                );

        return productRepository.findAll(
                pageable
        );
    }

    public List<Product> getProductsByCategory(
            String category
    ) {

        return productRepository
                .findByCategory(category);
    }

    public List<Product> getProductByPriceRange(
            Double minPrice,
            Double maxPrice
    ) {

        return productRepository
                .findByPriceBetween(
                        minPrice,
                        maxPrice
                );
    }

    public List<Product> searchProduct(
            String keyword
    ) {

        return productRepository
                .findByProductNameContaining(
                        keyword
                );
    }

    public List<Product> getProductsAbovePrice(
            Double price
    ) {

        return productRepository
                .getProductsAbovePrice(price);
    }
}