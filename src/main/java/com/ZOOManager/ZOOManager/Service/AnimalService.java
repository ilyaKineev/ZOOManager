package com.ZOOManager.ZOOManager.Service;

import com.ZOOManager.ZOOManager.Model.Animal;
import com.ZOOManager.ZOOManager.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AnimalService {

    AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAll() {
        return (List<Animal>) animalRepository.findAll();
    }

    public Animal getById(long id) {
        Optional<Animal> animal = animalRepository.findById(id);
        return animal.get();
    }

    public void create(Animal animal) {
        animalRepository.save(animal);
    }

    public boolean update(Animal animal, long id) {
        Optional<Animal> animalOptional = animalRepository.findById(id);
        Animal oldAnimal = animalOptional.get();
        oldAnimal.setName(animal.getName());
        oldAnimal.setKindOfAnimal(animal.getKindOfAnimal());
        oldAnimal.setPredator(animal.isPredator());
        animalRepository.save(oldAnimal);
        return true;
    }

    public boolean delete(long id) {
        animalRepository.deleteById(id);
        if (animalRepository.findById(id).isPresent()) return false;
        return true;
    }

    public boolean delete(List<Animal> animals) {
        for (Animal animal : animals) {
            animalRepository.deleteById(animal.getId());
        }
        return true;
    }

    public boolean delete() {
        animalRepository.deleteAll();
        return true;
    }


}
