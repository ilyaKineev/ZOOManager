package com.ZOOManager.ZOOManager.Model.JSONEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ProductInformation {
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "number")
    private int number;
    @JsonProperty(value = "quantity")
    private int quantity;
    @JsonProperty(value = "deficit")
    private Integer deficit;
    @JsonProperty(value = "measure")
    private String measure;

    public ProductInformation(String name, int number, int quantity, Integer deficit, String measure) {
        this.name = name;
        this.number = number;
        this.quantity = quantity;
        this.deficit = deficit;
        this.measure = measure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInformation that = (ProductInformation) o;
        return number == that.number && quantity == that.quantity && Objects.equals(name, that.name) && Objects.equals(deficit, that.deficit) && Objects.equals(measure, that.measure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, quantity, deficit, measure);
    }

    @Override
    public String toString() {
        return "ProductInformation{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", quantity=" + quantity +
                ", deficit=" + deficit +
                ", measure='" + measure + '\'' +
                '}';
    }
}
