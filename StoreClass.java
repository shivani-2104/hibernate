package com.company.Day11_Assessment;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class StoreClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private Set<ProductsClass> ProductsClass= new HashSet<>();

    public Set<ProductsClass> getProductsClass() {
        return ProductsClass;
    }

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
    void setAddress(String address)
    {
        this.address=address;
    }
    String getAddress()
    {
        return address;
    }
}
