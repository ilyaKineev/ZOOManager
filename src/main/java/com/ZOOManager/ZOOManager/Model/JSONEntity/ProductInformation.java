package com.ZOOManager.ZOOManager.Model.JSONEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductInformation {
    //    5. Получить информацию о питании животных на 7 дней от заданной даты. Название продукта, сколько продукта надо на 7 дней, сколько продукта всего есть, сколько его не хватает (если продукта достаточно, то вернуть null), единица измерения.
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


}
