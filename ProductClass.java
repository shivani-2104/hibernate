package com.company.Day11_Assessment;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class ProductClass {
//@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "custom-generator")
    @GenericGenerator(strategy = "com.company.Day11_Assessment.CustomId", name = "custom-generator")
    @Id
    private int id;
    private String name;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
