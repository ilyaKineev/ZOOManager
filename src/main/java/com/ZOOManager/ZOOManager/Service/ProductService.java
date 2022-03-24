package com.ZOOManager.ZOOManager.Service;


import com.ZOOManager.ZOOManager.Model.Product;
import com.ZOOManager.ZOOManager.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> readAll() {
        return (List<Product>) productRepository.findAll();
    }

    public Product read(long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    public void create(Product product) {
        productRepository.save(product);
    }

    public boolean update(Product product, long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        Product oldProduct = productOptional.get();
        oldProduct.setName(product.getName());
        oldProduct.setQuantity(product.getQuantity());
        oldProduct.setMeasure(product.getMeasure());
        oldProduct.setType(product.getType());
        productRepository.save(oldProduct);
        return true;
    }

    public boolean delete(long id) {
        productRepository.deleteById(id);
        return true;
    }

    public boolean delete(List<Product> products) {
        for (Product product : products) {
            productRepository.deleteById(product.getId());
        }
        return true;
    }

    public boolean delete() {
        productRepository.deleteAll();
        return true;
    }
}
