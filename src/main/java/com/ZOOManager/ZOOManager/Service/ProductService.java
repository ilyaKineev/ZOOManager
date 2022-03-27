package com.ZOOManager.ZOOManager.Service;


import com.ZOOManager.ZOOManager.Model.Product;
import com.ZOOManager.ZOOManager.Repository.AnimalRepository;
import com.ZOOManager.ZOOManager.Repository.DietRepository;
import com.ZOOManager.ZOOManager.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends AbstractService {


    public ProductService(ProductRepository productRepository, DietRepository dietRepository, AnimalRepository animalRepository) {
        super(productRepository, dietRepository, animalRepository);
    }

    public List<Product> readAll() {
        return (List<Product>) productRepository.findAll();
    }

    public Product readProduct(long id) {
        Optional<Product> product = (productRepository.findById(id));
        return product.orElseGet(Product::new);
    }

    public boolean create(Product product) {
        productRepository.save(product);
        return productRepository.existsById(product.getId());
    }

    public boolean update(Product product, long id) {
        Product oldProduct = readProduct(id);
        oldProduct.setName(product.getName());
        oldProduct.setQuantity(product.getQuantity());
        oldProduct.setMeasure(product.getMeasure());
        oldProduct.setType(product.getType());
        productRepository.save(oldProduct);
        return !oldProduct.equals(productRepository.existsById(id));
    }

    public boolean deleteProduct(long id) {
        productRepository.deleteById(id);
        return !productRepository.existsById(id);
    }

    public boolean delete(List<Product> products) {
        boolean isExists = false;
        for (Product product : products) {
            isExists = deleteProduct(product.getId());
        }
        return isExists;
    }

    public boolean delete() {
        productRepository.deleteAll();
        return productRepository.count() <= 0;
    }
}
