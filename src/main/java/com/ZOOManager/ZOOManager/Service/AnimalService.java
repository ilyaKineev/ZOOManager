package com.ZOOManager.ZOOManager.Service;

import com.ZOOManager.ZOOManager.Model.Animal;
import com.ZOOManager.ZOOManager.Repository.AnimalRepository;
import com.ZOOManager.ZOOManager.Repository.DietRepository;
import com.ZOOManager.ZOOManager.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService extends AbstractService {


    public AnimalService(ProductRepository productRepository, DietRepository dietRepository, AnimalRepository animalRepository) {
        super(productRepository, dietRepository, animalRepository);
    }

    public List<Animal> getAll() {
        return (List<Animal>) animalRepository.findAll();
    }

    public Animal getById(long id) {
        Optional<Animal> animal = (animalRepository.findById(id));
        return animal.orElseGet(Animal::new);
    }

    public boolean create(Animal animal) {
        animalRepository.save(animal);
        return animalRepository.existsById(animal.getId());
    }

    public boolean update(Animal animal, long id) {
        Animal oldAnimal = getById(id);
        oldAnimal.setName(animal.getName());
        oldAnimal.setKindOfAnimal(animal.getKindOfAnimal());
        oldAnimal.setPredator(animal.isPredator());
        animalRepository.save(oldAnimal);
        return !oldAnimal.equals(animalRepository.findById(id));
    }

    public boolean delete(long id) {
        animalRepository.deleteById(id);
        if (getById(id) == null) return false;
        return !animalRepository.existsById(id);
    }

    public boolean delete(List<Animal> animals) {
        boolean isExists = true;
        for (Animal animal : animals) {
            isExists = delete(animal.getId());
        }
        return isExists;
    }

    public boolean delete() {
        animalRepository.deleteAll();
        return animalRepository.count() <= 0;
    }


}
