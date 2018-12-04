package com.dsliunkova.kanbanforworkersmaster.ui;


import com.dsliunkova.kanbanforworkersmaster.entities.Cache;
import com.dsliunkova.kanbanforworkersmaster.entities.Car;
import com.dsliunkova.kanbanforworkersmaster.services.CarService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.server.VaadinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class CarLayout {
    private CarService carService;
    private CaseLayout caseLayout;
    private Cache cache;

    public CarLayout() {

    }

    @Autowired
    public CarLayout(CarService carService, CaseLayout caseLayout, Cache cache) {
        this.carService = carService;
        this.caseLayout = caseLayout;
        this.cache = cache;
    }


    public Div showCars() {
        Grid<Car> cars = new Grid<>();
        cars.addSelectionListener(selectionEvent -> {
            cache.setCar(selectionEvent.getFirstSelectedItem().get());
            UI.getCurrent().getPage().reload();
            //cache.setCar(selectionEvent.getFirstSelectedItem().get());
        });

        if (cache.getUser() != null) {
            int id = cache.getUser().getId();
            cars.setItems(carService.getCarsByOwnerId(id));
            cars.addColumn(Car::getVin).setHeader("VIN");
            cars.addColumn(Car::getColor).setHeader("Color");
            cars.addColumn(Car::getMake).setHeader("Make");
            cars.addColumn(Car::getModel).setHeader("Model");
            cars.addColumn(Car::getCarNumber).setHeader("Number");
        }
        Div div = new Div();
        div.add(cars);
        return div;
    }


}
