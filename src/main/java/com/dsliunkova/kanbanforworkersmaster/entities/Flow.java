package com.dsliunkova.kanbanforworkersmaster.entities;

import com.dsliunkova.kanbanforworkersmaster.entities.enums.Role;
import com.dsliunkova.kanbanforworkersmaster.entities.enums.Status;
import com.google.common.collect.Lists;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "flow")
public class Flow {
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "id")
    private Status id;
    @Column(name = "next_steps")
    private String nextSteps;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public Flow(String nextSteps, Role role) {
        this.nextSteps = nextSteps;
        this.role = role;
    }

    public Flow() {
    }

    public Status getId() {
        return id;
    }

    public void setId(Status id) {
        this.id = id;
    }

    public String getNextSteps() {
        return nextSteps;
    }

    public List<String> getParsedNextSteps() {
        return Lists.newArrayList(nextSteps.split(";"));
    }

    public void setNextSteps(String nextSteps) {
        this.nextSteps = nextSteps;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
