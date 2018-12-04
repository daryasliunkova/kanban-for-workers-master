package com.dsliunkova.kanbanforworkersmaster.ui;

import com.dsliunkova.kanbanforworkersmaster.entities.HistoryItem;
import com.dsliunkova.kanbanforworkersmaster.services.HistoryItemService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

@Component
@Scope("prototype")
public class HistoryLayout {
    private HistoryItemService historyItemService;

    @Autowired
    public HistoryLayout(HistoryItemService historyItemService) {
        this.historyItemService = historyItemService;
    }

    public Div showHistory() {
        Grid<HistoryItem> history = new Grid<>();

     //   Case caseId = ((Case) VaadinService.getCurrentRequest().getAttribute("case"));
        //if (caseId != null) {
            List<HistoryItem> listCars = historyItemService.getHistoryByCaseId(1);

            history.setItems(listCars);
            history.addColumn(HistoryItem::getChangeDate).setHeader("Change date");
            history.addColumn(HistoryItem::getStatus).setHeader("Status");
            history.addColumn(HistoryItem::getDescription).setHeader("Description");
    //    }
        Div div = new Div();
        div.add(history);
        return div;
    }
}
