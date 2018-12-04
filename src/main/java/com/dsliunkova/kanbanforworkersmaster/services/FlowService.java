package com.dsliunkova.kanbanforworkersmaster.services;

import com.dsliunkova.kanbanforworkersmaster.entities.Flow;
import com.dsliunkova.kanbanforworkersmaster.entities.enums.Role;
import com.dsliunkova.kanbanforworkersmaster.entities.enums.Status;
import com.dsliunkova.kanbanforworkersmaster.repositories.FlowRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowService {
    private FlowRepository flowRepository;

    @Autowired
    public FlowService(FlowRepository flowRepository) {
        this.flowRepository = flowRepository;
    };

    public List<Flow> getAllFlow() {
        return Lists.newArrayList(flowRepository.findAll());
    }

    public Flow getByRoleAndStatus(Status status) {
        return flowRepository.findByRoleAndId(Role.MASTER, status);
    }
}
