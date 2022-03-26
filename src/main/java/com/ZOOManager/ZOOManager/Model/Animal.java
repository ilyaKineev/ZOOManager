package com.ZOOManager.ZOOManager.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;


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

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kindOfAnimal='" + kindOfAnimal + '\'' +
                ", isPredator=" + isPredator +
                '}';
    }
}
