package com.dsliunkova.kanbanforworkersmaster.repositories;

import com.dsliunkova.kanbanforworkersmaster.entities.Flow;
import com.dsliunkova.kanbanforworkersmaster.entities.enums.Role;
import com.dsliunkova.kanbanforworkersmaster.entities.enums.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowRepository extends CrudRepository<Flow, Status>{
    Flow findByRoleAndId(Role role, Status id);
}
