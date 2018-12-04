package com.dsliunkova.kanbanforworkersmaster.ui;

import com.dsliunkova.kanbanforworkersmaster.entities.Car;
import com.dsliunkova.kanbanforworkersmaster.entities.User;
import com.dsliunkova.kanbanforworkersmaster.services.CarService;
import com.dsliunkova.kanbanforworkersmaster.services.UserService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope("prototype")
public class AddButtonsLayout {
    private UserService userService;
    private CarService carService;

    @Autowired
    public AddButtonsLayout(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
        showActions();
    }

    public Div showActions() {
        Div actions = new Div();
        Button addCar = new Button("Add car");
        addCar.addClickListener((ComponentEventListener<ClickEvent<Button>>) buttonClickEvent -> {
            Dialog dialog = new Dialog();
            dialog.setWidth("950px");
            dialog.setHeight("300px");

            FormLayout layoutWithFormItems = new FormLayout();

            ComboBox<String> comboBox = new ComboBox<>("");
            List<String> owners = new ArrayList<>();
            for (User user : userService.getAllCustomers()) {
                owners.add(user.getSurname() + " " + user.getName());
            }
            comboBox.setItems(owners);
            layoutWithFormItems.addFormItem(comboBox, "Owners");

            TextField make = new TextField();
            TextField carNumber = new TextField();
            TextField model = new TextField();
            TextField color = new TextField();
            TextField vin = new TextField();


            layoutWithFormItems.addFormItem(make, "Make");
            layoutWithFormItems.addFormItem(carNumber, "Car number");
            layoutWithFormItems.addFormItem(model, "Model");
            layoutWithFormItems.addFormItem(color, "Color");
            layoutWithFormItems.addFormItem(vin, "Vin");

            VerticalLayout buttonLayout = new VerticalLayout();
            Button okbutton = new Button("Add", ok -> {
                dialog.close();
            });

            buttonLayout.setWidth("100%");
            buttonLayout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, okbutton);
            buttonLayout.add(okbutton);
            dialog.add(layoutWithFormItems);
            dialog.add(buttonLayout);
            dialog.open();

            actions.add(dialog);

        });
        Button addCase = new Button("Add case");
        addCase.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                Dialog dialog = new Dialog();
                dialog.setWidth("950px");
                dialog.setHeight("300px");

                FormLayout layoutWithFormItems = new FormLayout();

                ComboBox<String> comboBox = new ComboBox<>("");
                List<String> owners = new ArrayList<>();
                for (Car car : carService.getCars()) {
                    owners.add(car.getVin() + " " + car.getMake());
                }
                comboBox.setItems(owners);
                layoutWithFormItems.addFormItem(comboBox, "Cars");

                TextField name = new TextField();
                TextField description = new TextField();
                DatePicker startDate = new DatePicker ();
                TextField endDate = new TextField();
                endDate.setEnabled(false);


                layoutWithFormItems.addFormItem(name, "Name");
                layoutWithFormItems.addFormItem(description, "Description");
                layoutWithFormItems.addFormItem(startDate, "Start date");
                layoutWithFormItems.addFormItem(endDate, "End date");

                VerticalLayout buttonLayout = new VerticalLayout();
                Button okbutton = new Button("Add", ok -> {
                    dialog.close();
                });

                buttonLayout.setWidth("100%");
                buttonLayout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, okbutton);
                buttonLayout.add(okbutton);
                dialog.add(layoutWithFormItems);
                dialog.add(buttonLayout);
                dialog.open();

                actions.add(dialog);
            }
        });

        actions.add(addCar, addCase);

        return actions;
    }
}
