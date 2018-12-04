package com.dsliunkova.kanbanforworkersmaster.ui;

import com.dsliunkova.kanbanforworkersmaster.entities.Cache;
import com.dsliunkova.kanbanforworkersmaster.services.UserService;
import com.dsliunkova.kanbanforworkersmaster.ui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class LoginView extends VerticalLayout {
    private UserService userService;
    private MainLayout headerLayout;
    private Cache cache;

    @Autowired
    public LoginView(UserService userService, MainLayout headerLayout, Cache cache) {
        this.userService = userService;
        this.headerLayout = headerLayout;
        this.cache = cache;

        Dialog dialog = new Dialog();
        dialog.setWidth("400px");
        dialog.setHeight("200px");

        FormLayout layoutWithFormItems = new FormLayout();

        TextField login = new TextField();
        login.setPlaceholder("Login");
        layoutWithFormItems.addFormItem(login, "Login");

        PasswordField password = new PasswordField();
        password.setPlaceholder("Password");
        layoutWithFormItems.addFormItem(password, "Password");

        VerticalLayout buttonLayout = new VerticalLayout();
        Button okbutton = new Button("OK", buttonClickEvent -> {
            String loginText = login.getValue();
            String passwordText = password.getValue();

            Notification.show(userService.getUserByLoginAndPassword(loginText, passwordText).toString());
            cache.setUser(userService.getUserByLoginAndPassword(loginText, passwordText));
            this.getUI().ifPresent(ui -> ui.navigate("main"));
            dialog.close();
        });

        buttonLayout.setWidth("100%");
        buttonLayout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, okbutton);
        buttonLayout.add(okbutton);
        dialog.add(layoutWithFormItems);
        dialog.add(buttonLayout);
        dialog.open();

        add(dialog);
    }

 /*   protected void init(VaadinRequest request) {
        VerticalLayout verticalLayout = new VerticalLayout();

        Dialog dialog = new Dialog();
        dialog.setWidth("400px");
        dialog.setHeight("200px");

        FormLayout layoutWithFormItems = new FormLayout();

        TextField login = new TextField();
        login.setPlaceholder("Login");
        layoutWithFormItems.addFormItem(login, "Login");


        PasswordField password = new PasswordField();
        password.setPlaceholder("Password");
        layoutWithFormItems.addFormItem(password, "Password");

        VerticalLayout buttonLayout = new VerticalLayout();
        Button okbutton = new Button("OK", buttonClickEvent -> {
            String loginText = login.getValue();
            String passwordText = password.getValue();

            Notification.show(userService.getUserByLoginAndPassword(loginText, passwordText).toString());
            VaadinService.getCurrentRequest().setAttribute("user", userService.getUserByLoginAndPassword(loginText, passwordText));
            // getUI().ifPresent(ui -> ui.navigate("car"));
            add(carLayout.showCars());
            dialog.close();
        });

        buttonLayout.setWidth("100%");
        buttonLayout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, okbutton);
        buttonLayout.add(okbutton);
        dialog.add(layoutWithFormItems);
        dialog.add(buttonLayout);
        dialog.open();
        verticalLayout.add(dialog);
        add(verticalLayout);
    }*/

}