package com.ZOOManager.ZOOManager.Controllers;

import com.ZOOManager.ZOOManager.Model.Animal;
import com.ZOOManager.ZOOManager.Service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalControllers {

    AnimalService animalService;

    @Autowired
    public AnimalControllers(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping(value = "/zoo/animals")
    public ResponseEntity<List<Animal>> get() {
        final List<Animal> animal = animalService.getAll();
        return animal != null && !animal.isEmpty()
                ? new ResponseEntity<>(animal, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/zoo/animals/{id}")
    public ResponseEntity<Animal> get(@PathVariable(name = "id") long id) {
        final Animal animal = animalService.getById(id);
        return animal != null
                ? new ResponseEntity<>(animal, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "zoo/animals")
    public ResponseEntity<?> add(@RequestBody Animal animal) {
        animalService.create(animal);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "zoo/animals/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Animal animal) {
        final boolean updated = animalService.update(animal, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/zoo/animals/{id}")
    public ResponseEntity<?> remove(@PathVariable(name = "id") long id) {
        final boolean deleted = animalService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/zoo/animals/group")
    public ResponseEntity<?> remove(@RequestBody List<Animal> animals) {
        final boolean deleted = animalService.delete(animals);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/zoo/animals")
    public ResponseEntity<?> remove() {
        final boolean deleted = animalService.delete();
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
