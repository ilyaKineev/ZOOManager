package com.ZOOManager.ZOOManager.Controllers;

import com.ZOOManager.ZOOManager.Model.JSONEntity.AnimalInformation;
import com.ZOOManager.ZOOManager.Model.JSONEntity.ProductInformation;
import com.ZOOManager.ZOOManager.Service.ZooService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZooControllers {

    Logger logger = org.slf4j.LoggerFactory.getLogger(AnimalControllers.class);
    ZooService zooService;

    @Autowired
    public ZooControllers(ZooService zooService) {
        this.zooService = zooService;
    }

    @GetMapping(value = "/zoo/week")
    public ResponseEntity<List<ProductInformation>> readProduct() {
        logger.info("Get_Products_By_One_Week");
        List<ProductInformation> list = zooService.readProductInformationByWeek();
        return list != null && !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/zoo/info")
    public ResponseEntity<List<AnimalInformation>> readAnimal() {
        logger.info("Get_All_Info_by_ZOO");
        List<AnimalInformation> list = zooService.readAnimalInformation();
        return list != null && !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "zoo/quantity")
    public ResponseEntity<?> updateQuantityProductByID(@RequestParam(name = "id") long id, @RequestParam(name = "quantity") int quantity) {
        logger.info("Update_Quantity_By_id");
        final boolean update = zooService.updateQuantityProductByID(id, quantity);
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "zoo/product")
    public ResponseEntity<?> createProductToAnimal(@RequestParam(name = "id") long id, @RequestParam(name = "product") long product) {
        logger.info("Set_Product_For_An_Animal");
        final boolean create = zooService.createProductToAnimal(id, product);
        return create
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "zoo/products")
    public ResponseEntity<?> createProductToAnimal(@RequestParam(name = "id") long id, @RequestParam(name = "product") long[] product) {
        logger.info("Set_Group_Product_For_An_Animal");
        final boolean answer = zooService.createProductToAnimal(id, product);
        return answer
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "zoo/norm")
    public ResponseEntity<?> updateNorm(@RequestParam(name = "id") long id, @RequestParam(name = "norm") int norm) {
        final boolean update = zooService.updateNorm(id, norm);
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
