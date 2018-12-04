package com.dsliunkova.kanbanforworkersmaster.repositories;


import com.dsliunkova.kanbanforworkersmaster.entities.HistoryItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryItemRepository extends CrudRepository<HistoryItem, Integer> {
    public List<HistoryItem> findAllByIssueId(int id);
}
