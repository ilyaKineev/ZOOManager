package com.ZOOManager.ZOOManager.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "diet")
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JsonProperty(value = "animal")
    private Animal animal;
    @ManyToOne
    @JsonProperty(value = "product")
    private Product product;
    @JsonProperty(value = "norm")
    private int norm;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNorm() {
        return norm;
    }

    public void setNorm(int norm) {
        this.norm = norm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diet diet = (Diet) o;
        return id == diet.id && norm == diet.norm && Objects.equals(animal, diet.animal) && Objects.equals(product, diet.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animal, product, norm);
    }

    @Override
    public String toString() {
        return "Diet{" +
                "id=" + id +
                ", animal=" + animal +
                ", product=" + product +
                ", norm=" + norm +
                '}';
    }
}
