package com.ZOOManager.ZOOManager.Model.JSONEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    public String toString() {
        return "ProductForAnimal{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", norm=" + norm +
                ", measure='" + measure + '\'' +
                '}';
    }
}
