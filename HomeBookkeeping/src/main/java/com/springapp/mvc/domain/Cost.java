package com.springapp.mvc.domain;

import com.springapp.mvc.repository.GroupCostRepository;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "cost")
public class Cost {

    @Id
    @Column(name = "idCost")
    @GeneratedValue()
    private int id;

    @Column(name = "groupCost")
    private String groupCost;

    @Column(name = "nameCost")
    private String nameCost;



    @JoinColumn(name = "idgroupCost", referencedColumnName = "idGroupCost")
    @ManyToOne
    private GroupCost idgroupCost;
    @JoinColumn(name = "idMember", referencedColumnName = "idmemberOfFamily")
    @ManyToOne
    private MemberOfFamily idMember;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCost", fetch = FetchType.EAGER)
    private List<PropertiesCost> propertiesCostCollection;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupCost() {
        return groupCost;
    }

    public void setGroupCost(String groupCost) {
        this.groupCost = groupCost;
    }

    public String getNameCost() {
        return nameCost;
    }

    public void setNameCost(String nameCost) {
        this.nameCost = nameCost;
    }




    public MemberOfFamily getIdMember() {
        return idMember;
    }

    public void setIdMember(MemberOfFamily idMember) {
        this.idMember = idMember;
    }

    public List<PropertiesCost> getPropertiesCostCollection() {
        return propertiesCostCollection;
    }

    public void setPropertiesCostCollection(List<PropertiesCost> propertiesCostCollection) {
        this.propertiesCostCollection = propertiesCostCollection;
    }

    public GroupCost getIdgroupCost() {
        return idgroupCost;
    }


    public void setIdgroupCost(GroupCost idgroupCost) {
        this.idgroupCost = idgroupCost;
    }

}
