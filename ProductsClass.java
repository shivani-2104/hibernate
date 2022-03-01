package com.company.Day11_Assessment;

import jakarta.persistence.*;
@Entity
public class ProductsClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    StoreClass store;
    void setId(int id)
    {
        this.id=id;
    }
    int getId()
    {
        return id;
    }
    void setName(String name)
    {
        this.name=name;
    }
    String getName()
    {
        return name;
    }
    void setStore(StoreClass store)
    {
        this.store=store;
    }
    StoreClass getStore()
    {
        return store;
    }

}
