package com.dsliunkova.kanbanforworkersmaster.entities;


import org.springframework.stereotype.Component;

@Component
public class Cache {
    private User user;
    private Car car;
    private Case aCase;
    private HistoryItem historyItem;

    public Cache(User user, Car car, Case aCase, HistoryItem historyItem) {
        this.user = user;
        this.car = car;
        this.aCase = aCase;
        this.historyItem = historyItem;
    }

    public Cache() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Case getaCase() {
        return aCase;
    }

    public void setaCase(Case aCase) {
        this.aCase = aCase;
    }

    public HistoryItem getHistoryItem() {
        return historyItem;
    }

    public void setHistoryItem(HistoryItem historyItem) {
        this.historyItem = historyItem;
    }
}
