package com.dsliunkova.kanbanforworkersmaster.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@org.springframework.stereotype.Component
@Scope("prototype")
@Route("main")
public class MainLayout extends VerticalLayout{
    private CarLayout carLayout;
    private CaseLayout caseLayout;
    private HistoryLayout historyLayout;
    private AddButtonsLayout addButtonsLayout;

    @Autowired
    public MainLayout(CarLayout carLayout, CaseLayout caseLayout, HistoryLayout historyLayout, AddButtonsLayout addButtonsLayout) {
        this.carLayout = carLayout;
        this.caseLayout = caseLayout;
        this.historyLayout = historyLayout;
        this.addButtonsLayout = addButtonsLayout;

        showMainPage();
    }

    public VerticalLayout showMainPage() {
        Tab actions = new Tab("Add");
        Div actionsDiv = addButtonsLayout.showActions();

        Tab tab1 = new Tab("Cars");
        Div page1 = carLayout.showCars();
        page1.setVisible(false);

        Tab tab2 = new Tab("Cases");
        Div page2 = caseLayout.showCases();
        page2.setVisible(false);

        Tab tab3 = new Tab("History");
        Div page3 = historyLayout.showHistory();
        page3.setVisible(false);

        Map<Tab, Div> tabsToPages = new HashMap<>();
        tabsToPages.put(actions, actionsDiv);
        tabsToPages.put(tab1, page1);
        tabsToPages.put(tab2, page2);
        tabsToPages.put(tab3, page3);

        Tabs tabs = new Tabs(actions, tab1, tab2, tab3);
        Div pages = new Div(actionsDiv, page1, page2, page3);
        pages.setWidth("1300px");
        Set<Div> pagesShown = Stream.of(page1)
                .collect(Collectors.toSet());

        tabs.addSelectedChangeListener(event -> {
            pagesShown.forEach(page -> page.setVisible(false));
            pagesShown.clear();
            Div selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
            selectedPage.setWidth("1300px");
            pagesShown.add(selectedPage);
        });

        add(tabs);
        add(pages);

        return this;
    }
}
