package com.ZOOManager.ZOOManager.Service;


import com.ZOOManager.ZOOManager.Model.Animal;
import com.ZOOManager.ZOOManager.Model.Diet;
import com.ZOOManager.ZOOManager.Model.JSONEntity.AnimalInformation;
import com.ZOOManager.ZOOManager.Model.JSONEntity.ProductForAnimal;
import com.ZOOManager.ZOOManager.Model.JSONEntity.ProductInformation;
import com.ZOOManager.ZOOManager.Model.Product;
import com.ZOOManager.ZOOManager.Repository.AnimalRepository;
import com.ZOOManager.ZOOManager.Repository.DietRepository;
import com.ZOOManager.ZOOManager.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZooService {
    ProductRepository productRepository;
    DietRepository dietRepository;
    AnimalRepository animalRepository;

    public ZooService(ProductRepository productRepository, DietRepository dietRepository, AnimalRepository animalRepository) {
        this.productRepository = productRepository;
        this.dietRepository = dietRepository;
        this.animalRepository = animalRepository;
    }

    public List<ProductInformation> get() {
        List<Diet> dietList = (List<Diet>) dietRepository.findAll();
        Map<Product, Integer> map = new HashMap<>();

        for (Diet diet : dietList) {
            if (map.containsKey(diet.getProduct())) {
                Integer norm = map.get(diet.getProduct());
                norm = norm + diet.getNorm();
                map.put(diet.getProduct(), norm);
            } else {
                map.put(diet.getProduct(), diet.getNorm());
            }
        }

        List<ProductInformation> list = new ArrayList<>();
        for (Map.Entry<Product, Integer> m : map.entrySet()) {
            String name = m.getKey().getName();
            int number = m.getValue() * 7;
            int quantity = m.getKey().getQuantity();
            String measure = m.getKey().getMeasure();
            Integer deficit = null;
            if (quantity - number < 0) {
                deficit = Math.abs(quantity - number);
            }
            ProductInformation productInformation = new ProductInformation(name, number, quantity, deficit, measure);
            list.add(productInformation);
        }

        return list;
    }
//      1. Название животного, вид, список продуктов (название, тип, потребление, единица измерения).
//      2. Необязательные параметры запроса: вид животного, тип продукта, хищник или нет и произвольная строка с названием животного (строка может не содержать полное название животного).

    public List<AnimalInformation> getAnimal() {
        List<AnimalInformation> list = new ArrayList<>();
        List<Diet> dietList = (List<Diet>) dietRepository.findAll();

        for (Diet diet : dietList) {
            Product product = diet.getProduct();
            Animal animal = diet.getAnimal();

            AnimalInformation animalInformation = new AnimalInformation(animal.getName(), animal.getKindOfAnimal());
            ProductForAnimal productForAnimal = new ProductForAnimal(product.getName(), product.getType(), diet.getNorm(), product.getMeasure());


            if (list.contains(animalInformation)) {
                AnimalInformation animalInformationNew = list.get(list.indexOf(animalInformation));
                animalInformationNew.addProductForAnimals(productForAnimal);
            } else {
                animalInformation.addProductForAnimals(productForAnimal);
                list.add(animalInformation);
            }
        }
        return list;
    }

    public void update(long id, int quantity) {
        Product product = productRepository.findById(id).get();
        product.setQuantity(quantity);
        productRepository.save(product);
    }

    //    5. Назначение продукта животному.

    public boolean addProduct(long id, long products_id) {
        Animal animal = animalRepository.findById(id).get();
        Product product = productRepository.findById(products_id).get();
        Diet diet = new Diet();
        diet.setAnimal(animal);
        diet.setProduct(product);
        dietRepository.save(diet);
        return true;
    }
    public boolean addProduct(long id, long[] products_id) {
        Animal animal = animalRepository.findById(id).get();
        for (long i: products_id) {
            Product product = productRepository.findById(Long.valueOf(i)).get();
            Diet diet = new Diet();
            diet.setAnimal(animal);
            diet.setProduct(product);
            dietRepository.save(diet);
        }
        return true;
    }

    public void updateNorm(long id, int norm) {
        Diet diet = dietRepository.findById(id).get();
        diet.setNorm(norm);
        dietRepository.save(diet);
    }
}
