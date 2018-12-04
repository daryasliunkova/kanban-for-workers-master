package com.dsliunkova.kanbanforworkersmaster.ui;

import com.dsliunkova.kanbanforworkersmaster.entities.Cache;
import com.dsliunkova.kanbanforworkersmaster.entities.Case;
import com.dsliunkova.kanbanforworkersmaster.entities.Flow;
import com.dsliunkova.kanbanforworkersmaster.entities.enums.Status;
import com.dsliunkova.kanbanforworkersmaster.services.CaseService;
import com.dsliunkova.kanbanforworkersmaster.services.FlowService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.selection.SelectionListener;
import com.vaadin.flow.server.VaadinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class CaseLayout {
    private CaseService caseService;
    private HistoryLayout historyLayout;
    private FlowService flowService;
    private Cache cache;

    public CaseLayout() {

    }

    @Autowired
    public CaseLayout(CaseService caseService, HistoryLayout historyLayout, Cache cache, FlowService flowService) {
        this.caseService = caseService;
        this.cache = cache;
        this.historyLayout = historyLayout;
        this.flowService = flowService;
    }


    public Div showCases() {
        Grid<Case> cases = new Grid<>();
        cases.addSelectionListener((SelectionListener<Grid<Case>, Case>) selectionEvent -> {
            VaadinService.getCurrentRequest().setAttribute("case", selectionEvent.getFirstSelectedItem().get());
            UI.getCurrent().getPage().reload();
        });

        if (cache.getCar() != null) {
            List<Case> listCars = caseService.getCasesByOwnerAndCar(cache.getCar().getId());
            cases.setItems(listCars);
            cases.addColumn(Case::getName).setHeader("Problem");
            cases.addColumn(Case::getDescription).setHeader("Description");
            cases.addColumn(Case::getStartDate).setHeader("Created by");
            cases.addColumn(Case::getEndDate).setHeader("End date");
            cases.addColumn(Case::getStatus).setHeader("Status");
            cases.addColumn(new ComponentRenderer<>(currentCase -> {
               ComboBox<String> flow = new ComboBox<>();
               flow.setItems(flowService.getByRoleAndStatus(currentCase.getStatus()).getParsedNextSteps());
               return flow;
            })).setHeader("Changed status");
        }

        Div div = new Div();
        div.add(cases);
        return div;
    }
}
