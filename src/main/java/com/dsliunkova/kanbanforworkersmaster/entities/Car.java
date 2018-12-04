package com.dsliunkova.kanbanforworkersmaster.entities;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @Column(name = "make")
    private String make;
    @Column(name = "carNumber")
    private String carNumber;
    @Column(name = "model")
    private String model;
    @Column(name = "color")
    private String color;
    @Column(name = "year")
    private int year;
    @Column(name = "vin")
    private String vin;

    public Car() {

    }

    public Car(User owner, String make, String carNumber, String model, String color, int year, String vin) {
        this.owner = owner;
        this.make = make;
        this.carNumber = carNumber;
        this.model = model;
        this.color = color;
        this.year = year;
        this.vin = vin;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
