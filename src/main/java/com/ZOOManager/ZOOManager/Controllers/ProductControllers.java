package com.ZOOManager.ZOOManager.Controllers;

import com.ZOOManager.ZOOManager.Model.Product;
import com.ZOOManager.ZOOManager.Service.ProductService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductControllers {

    Logger logger = org.slf4j.LoggerFactory.getLogger(ProductControllers.class);
    ProductService productService;

    @Autowired
    public ProductControllers(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "zoo/products")
    public ResponseEntity<?> read() {
        logger.info("Get_All_Products");
        final List<Product> products = productService.readAll();
        return products != null && !products.isEmpty()
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "zoo/products/{id}")
    public ResponseEntity<?> read(@PathVariable(name = "id") long id) {
        logger.info("Get_Info_Product_By_ID");
        final Product product = productService.readProduct(id);
        return product != null
                ? new ResponseEntity<>(product, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "zoo/products")
    public ResponseEntity<?> create(@RequestBody Product product) {
        logger.info("Create_New_Product");
        final boolean create = productService.create(product);
        return create
                ? new ResponseEntity<>(create, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "zoo/products/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Product product) {
        logger.info("Update_Product");
        final boolean updated = productService.update(product, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "zoo/products/{id}")
    public ResponseEntity<?> removeById(@PathVariable(name = "id") long id) {
        logger.info("Remove_Product_By_ID");
        final boolean deleted = productService.deleteProduct(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "zoo/products/group")
    public ResponseEntity<?> removeGroup(@RequestBody List<Product> products) {
        logger.info("Remove_Group_Products");
        final boolean deleted = productService.delete(products);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "zoo/products")
    public ResponseEntity<?> removeAll() {
        logger.info("Remove_All_Products");
        final boolean deleted = productService.delete();
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
