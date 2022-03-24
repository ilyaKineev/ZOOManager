package com.ZOOManager.ZOOManager.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Type(type = "string")
    private String kindOfAnimal;
    private boolean isPredator;
    @OneToMany(fetch = FetchType.LAZY)
    @Type(type = "product")
    private List<Product> products;

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

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public boolean isPredator() {
        return isPredator;
    }

    public void setPredator(boolean predator) {
        isPredator = predator;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kindOfAnimal=" + kindOfAnimal +
                ", isPredator=" + isPredator +
                ", products=" + products +
                '}';
    }
}
