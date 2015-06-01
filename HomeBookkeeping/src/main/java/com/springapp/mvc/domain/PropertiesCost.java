package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "propertiesCost")
public class PropertiesCost {

    @Id
    @Column(name = "idPropertiesCost")
    @GeneratedValue()
    private int id;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "sum")
    private float sum;

    @JoinColumn(name = "idCost", referencedColumnName = "idCost")
    @ManyToOne
    private Cost idCost;


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

    public Cost getIdCost() {
        return idCost;
    }

    public void setIdCost(Cost idCost) {
        this.idCost = idCost;
    }
}
