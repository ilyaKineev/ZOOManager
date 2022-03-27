package com.ZOOManager.ZOOManager.Model.JSONEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ProductForAnimal {
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "type")
    private String type;
    @JsonProperty(value = "norm")
    private int norm;
    @JsonProperty(value = "measure")
    private String measure;

    public ProductForAnimal(String name, String type, int norm, String measure) {
        this.name = name;
        this.type = type;
        this.norm = norm;
        this.measure = measure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductForAnimal that = (ProductForAnimal) o;
        return norm == that.norm && Objects.equals(name, that.name) && Objects.equals(type, that.type) && Objects.equals(measure, that.measure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, norm, measure);
    }

    @Override
    public String toString() {
        return "ProductForAnimal{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", norm=" + norm +
                ", measure='" + measure + '\'' +
                '}';
    }
}
