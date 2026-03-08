package io.github.otavioyukio.foodfly.product;

import org.springframework.data.domain.Sort;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product newProduct) {
        productRepository.save(newProduct);
        return newProduct;
    }
}
