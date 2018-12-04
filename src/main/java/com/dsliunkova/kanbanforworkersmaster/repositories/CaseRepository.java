package com.dsliunkova.kanbanforworkersmaster.repositories;

import com.dsliunkova.kanbanforworkersmaster.entities.Case;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepository extends CrudRepository<Case, Integer> {
    public List<Case> findAllByCarId(int id);
}
