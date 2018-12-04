package com.dsliunkova.kanbanforworkersmaster.services;


import com.dsliunkova.kanbanforworkersmaster.entities.Case;
import com.dsliunkova.kanbanforworkersmaster.repositories.CaseRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {
    private CaseRepository caseRepository;

    public CaseService() {

    }

    @Autowired
    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public List<Case> getCases() {
        return Lists.newArrayList(caseRepository.findAll());
    }

    public List<Case> getCasesByOwnerAndCar(int carId) {
        return caseRepository.findAllByCarId(carId);
    }
}
