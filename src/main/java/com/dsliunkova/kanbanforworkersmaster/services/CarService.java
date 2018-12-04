package com.dsliunkova.kanbanforworkersmaster.services;

import com.dsliunkova.kanbanforworkersmaster.entities.Car;
import com.dsliunkova.kanbanforworkersmaster.repositories.CarRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private CarRepository repository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.repository = carRepository;
    }

    public CarService() {
    }

    public List<Car> getCarsByOwnerId(int id) {
        return repository.findAllByOwnerId(id);
    }
    public List<Car> getCars() {
        return Lists.newArrayList(repository.findAll());
    }

    public Optional<Car> getCarById(int id) {
        return repository.findById(id);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
