package com.dsliunkova.kanbanforworkersmaster.entities;

import com.dsliunkova.kanbanforworkersmaster.entities.enums.HistoryStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history_item")
public class HistoryItem {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn(name = "issue_id")
    private Case issue;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private HistoryStatus status;
    @Column(name = "change_date")
    private Date changeDate;
    @Column(name = "description")
    private String description;
    @Column(name = "old_value", nullable = true)
    private String oldValue;
    @Column(name = "new_value", nullable = true)
    private String newValue;

    public HistoryItem() {
    }

    public HistoryItem(Case issue, User user, HistoryStatus status, Date changeDate, String description, String oldValue, String newValue) {
        this.issue = issue;
        this.user = user;
        this.status = status;
        this.changeDate = changeDate;
        this.description = description;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Case getIssue() {
        return issue;
    }

    public void setIssue(Case issue) {
        this.issue = issue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HistoryStatus getStatus() {
        return status;
    }

    public void setStatus(HistoryStatus status) {
        this.status = status;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}
