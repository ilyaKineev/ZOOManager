package com.ZOOManager.ZOOManager.Service;

import com.ZOOManager.ZOOManager.Repository.AnimalRepository;
import com.ZOOManager.ZOOManager.Repository.DietRepository;
import com.ZOOManager.ZOOManager.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbstractService {

    ProductRepository productRepository;
    DietRepository dietRepository;
    AnimalRepository animalRepository;

    @Autowired
    public AbstractService(ProductRepository productRepository, DietRepository dietRepository, AnimalRepository animalRepository) {
        this.productRepository = productRepository;
        this.dietRepository = dietRepository;
        this.animalRepository = animalRepository;
    }


}
