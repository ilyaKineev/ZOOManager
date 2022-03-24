package com.ZOOManager.ZOOManager.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "measure")
    @Type(type = "string")
    private String measure;
    @Column(name = "type")
    @Type(type = "string")
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

//INSERT INTO PRODUCT  VALUES(1, 'VEGETABLE', 'pcs', 'Carrot',100);
//INSERT INTO PRODUCT  VALUES(1, 'VEGETABLE', 'pcs', 'Carrot',100);
//INSERT INTO PRODUCT  VALUES(1, 'VEGETABLE', 'pcs', 'Carrot',100);
//INSERT INTO PRODUCT  VALUES(1, 'VEGETABLE', 'pcs', 'Carrot',100);
//INSERT INTO PRODUCT  VALUES(1, 'VEGETABLE', 'pcs', 'Carrot',100);
