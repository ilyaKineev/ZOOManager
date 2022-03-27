package com.ZOOManager.ZOOManager.Model.JSONEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnimalInformation {
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "kindOfAnimal")
    private String kindOfAnimal;
    @JsonProperty(value = "products")
    private List<ProductForAnimal> products;

    public AnimalInformation(String name, String kindOfAnimal) {
        this.name = name;
        this.kindOfAnimal = kindOfAnimal;
        this.products = new ArrayList<>();
    }

    public void addProductForAnimals(ProductForAnimal productForAnimals) {
        products.add(productForAnimals);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalInformation that = (AnimalInformation) o;
        return Objects.equals(name, that.name) && Objects.equals(kindOfAnimal, that.kindOfAnimal) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kindOfAnimal, products);
    }

    @Override
    public String toString() {
        return "AnimalInformation{" +
                "name='" + name + '\'' +
                ", kindOfAnimal='" + kindOfAnimal + '\'' +
                ", products=" + products +
                '}';
    }
}
