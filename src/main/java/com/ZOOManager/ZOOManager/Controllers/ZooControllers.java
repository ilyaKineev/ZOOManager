package com.ZOOManager.ZOOManager.Controllers;

import com.ZOOManager.ZOOManager.Model.JSONEntity.AnimalInformation;
import com.ZOOManager.ZOOManager.Model.JSONEntity.ProductInformation;
import com.ZOOManager.ZOOManager.Model.Product;
import com.ZOOManager.ZOOManager.Service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ZooControllers {

    ZooService zooService;

    @Autowired
    public ZooControllers(ZooService zooService) {
        this.zooService = zooService;
    }

    @GetMapping(value = "/zoo")
    public ResponseEntity<List<ProductInformation>> read() {
        List<ProductInformation> list = zooService.get();
        return list != null && !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/zooinfo")
    public ResponseEntity<List<AnimalInformation>> readAnimal() {
        List<AnimalInformation> list = zooService.getAnimal();
        return list != null && !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "zoo/quantity")
    public ResponseEntity<?> update(@RequestParam(name = "id") long id, @RequestParam(name = "quantity") int quantity) {
        zooService.update(id,quantity);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @PutMapping(value = "zoo/add")
    public ResponseEntity<?> addProduct(@RequestParam(name = "id") long id, @RequestParam(name = "product") long product) {
        final boolean updated = zooService.addProduct(id, product);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "zoo/adds")
    public ResponseEntity<?> addProducts(@RequestParam(name = "id") long id, @RequestParam(name = "product") long[] product) {
        final boolean updated = zooService.addProduct(id, product);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "zoo/norm")
    public ResponseEntity<?> updateNorm(@RequestParam(name = "id") long id, @RequestParam(name = "norm") int norm) {
        zooService.updateNorm(id,norm);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
