package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Goal")
public class Goal {
    @Id
    @Column(name = "idGoal")
    @GeneratedValue()
    private int id;

    @Column(name = "collected")
    private String collected;

    @Column(name = "sum")
    private float sum;

    @Column(name = "ante")
    private float ante;

    @Column(name = "start")
    @Temporal(TemporalType.DATE)
    private Date start;
    @Column(name = "finish")
    @Temporal(TemporalType.DATE)
    private Date finish;

    @JoinColumn(name = "idMemberOfFamily", referencedColumnName = "idMemberOfFamily")
    @ManyToOne
    private MemberOfFamily idMemberOfFamily;

    @JoinColumn(name = "idGroupCost", referencedColumnName = "idGroupCost")
    @ManyToOne
    private GroupCost idGroupCost;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollected() {
        return collected;
    }

    public void setCollected(String collected) {
        this.collected = collected;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }



    public MemberOfFamily getIdMemberOfFamily() {
        return idMemberOfFamily;
    }

    public void setIdMemberOfFamily(MemberOfFamily idMemberOfFamily) {
        this.idMemberOfFamily = idMemberOfFamily;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public float getAnte() {
        return ante;
    }

    public void setAnte(float ante) {
        this.ante = ante;
    }


    public GroupCost getIdGroupCost() {
        return idGroupCost;
    }

    public void setIdGroupCost(GroupCost idGroupCost) {
        this.idGroupCost = idGroupCost;
    }
}
