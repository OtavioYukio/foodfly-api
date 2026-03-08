package io.github.otavioyukio.foodfly.product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();
    Product createProduct(Product newProduct);
    Product updateProductById(Long id, Product newProduct);
    void deleteProductById(Long id);
}
