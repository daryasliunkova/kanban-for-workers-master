package com.dsliunkova.kanbanforworkersmaster.services;

import com.dsliunkova.kanbanforworkersmaster.entities.HistoryItem;
import com.dsliunkova.kanbanforworkersmaster.repositories.HistoryItemRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryItemService {
    private HistoryItemRepository repository;

    public HistoryItemService() {

    }

    @Autowired
    public HistoryItemService(HistoryItemRepository historyItemRepository) {
        this.repository = historyItemRepository;
    }

    public List<HistoryItem> getHistoryItems() {
        return Lists.newArrayList(repository.findAll());
    }

    public Optional<HistoryItem> getHistoryItemById(int id) {
        return repository.findById(new Integer(id));
    }

    public void insertHistoryItem(HistoryItem historyItem) {
        repository.save(historyItem);
    }

    public List<HistoryItem> getHistoryByCaseId(int id) {
        return repository.findAllByIssueId(id);
    }
}
