package com.ZOOManager.ZOOManager.Controllers;

import com.ZOOManager.ZOOManager.Model.Product;
import com.ZOOManager.ZOOManager.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductControllers {

    ProductService productService;

    @Autowired
    public ProductControllers(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "zoo/products")
    public ResponseEntity<?> read() {
        final List<Product> products = productService.readAll();
        return products != null && !products.isEmpty()
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "zoo/products/{id}")
    public ResponseEntity<?> read(@PathVariable(name = "id") long id) {
        final Product product = productService.read(id);

        return product != null
                ? new ResponseEntity<>(product, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "zoo/products")
    public ResponseEntity<?> create(@RequestBody Product product) {
        productService.create(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "zoo/products/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Product product) {
        final boolean updated = productService.update(product, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "zoo/products/{id}")
    public ResponseEntity<?> removeById(@PathVariable(name = "id") long id) {
        final boolean deleted = productService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "zoo/products/group")
    public ResponseEntity<?> removeGroup(@RequestBody List<Product> products) {
        final boolean deleted = productService.delete(products);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "zoo/products")
    public ResponseEntity<?> removeAll() {
        final boolean deleted = productService.delete();
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
