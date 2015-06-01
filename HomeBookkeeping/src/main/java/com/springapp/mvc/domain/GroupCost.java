package com.springapp.mvc.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "groupcost")
public class GroupCost {

    @Id
    @Column(name = "idgroupCost")
    @GeneratedValue()
    private int id;

    @Column(name = "nameGroup")
    private String nameGroup;

    @Column(name = "priority")
    private String priority;

    @Column(name = "sum")
    private int sum;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGroupCost")
    private List<Goal> goalCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgroupCost")
     private List<Cost> costCollection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public List<Cost> getCostCollection() {
        return costCollection;
    }

    public void setCostCollection(List<Cost> costCollection) {
        this.costCollection = costCollection;
    }

    public void Sum() {

    }


    public List<Goal> getGoalCollection() {
        return goalCollection;
    }

    public void setGoalCollection(List<Goal> goalCollection) {
        this.goalCollection = goalCollection;
    }
}
