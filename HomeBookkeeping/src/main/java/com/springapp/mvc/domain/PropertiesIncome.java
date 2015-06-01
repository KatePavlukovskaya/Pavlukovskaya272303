package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "propertiesIncome")
public class PropertiesIncome {
    @Id
    @Column(name = "idPropertiesIncome")
    @GeneratedValue()
    private int id;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "sum")
    private float sum;

    @JoinColumn(name = "idIncome", referencedColumnName = "idIncome")
    @ManyToOne
    private Income idIncome;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public Income getIdIncome() {
        return idIncome;
    }

    public void setIdIncome(Income idIncome) {
        this.idIncome = idIncome;
    }
}
