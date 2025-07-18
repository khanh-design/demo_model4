package com.example.demo_model4.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 50)
    private String name;
    @NotBlank
    @Min(value = 100000, message = "Giá bát đầu phải là số và thấp nhất phải là 100.000 VND")
    private double price;
    @NotBlank
    private String status;

    @JoinColumn(name = "type_id")
    @ManyToOne
    private Type type;

    public Product() {

    }

    public Product(Long id, String name, double price, String status, Type type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
