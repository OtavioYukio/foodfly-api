package io.github.otavioyukio.foodfly.product;

import org.springframework.data.domain.Sort;

import javax.swing.text.html.Option;
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
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found."));

        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        product.setImageUrl(newProduct.getImageUrl());
        product.setDescription(newProduct.getDescription());
        product.setIsActive(newProduct.getIsActive());
        product.setCategory(newProduct.getCategory());

        return productRepository.save(product);
    }
}
