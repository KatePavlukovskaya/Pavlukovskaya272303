package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "groupIncome")
public class GroupIncome {

    @Id
    @Column(name = "idGroupIncome")
    @GeneratedValue()
    private int id;

    @Column(name = "nameGroup")
    private String nameGroup;

    @Column(name = "sum")
    private int sum;

    @OneToMany(mappedBy = "idgroupIncome")
    private Collection<Income> incomeCollection;

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

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


    public Collection<Income> getIncomeCollection() {
        return incomeCollection;
    }

    public void setIncomeCollection(Collection<Income> incomeCollection) {
        this.incomeCollection = incomeCollection;
    }


}
