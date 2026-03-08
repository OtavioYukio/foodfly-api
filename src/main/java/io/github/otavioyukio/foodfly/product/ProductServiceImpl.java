package io.github.otavioyukio.foodfly.product;

import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

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

    public Product updateProductById(Long id, Product newProduct) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            return null;
        }

        Product existingProduct = product.get();
        existingProduct.setName(newProduct.getName());
        existingProduct.setPrice(newProduct.getPrice());
        existingProduct.setImageUrl(newProduct.getImageUrl());
        existingProduct.setDescription(newProduct.getDescription());
        existingProduct.setIsActive(newProduct.getIsActive());
        existingProduct.setCategory(newProduct.getCategory());

        return productRepository.save(existingProduct);
    }
}
