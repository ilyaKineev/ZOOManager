package com.ZOOManager.ZOOManager.Repository;

import com.ZOOManager.ZOOManager.Model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
}