package com.ZOOManager.ZOOManager.Repository;

import com.ZOOManager.ZOOManager.Model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
