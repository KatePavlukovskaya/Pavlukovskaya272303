package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "income")
public class Income {

    @Id
    @Column(name = "idIncome")
    @GeneratedValue()
    private int id;

    @Column(name = "groupIncome")
    private String groupIncome;

    @Column(name = "nameIncome")
    private String nameIncome;

    @JoinColumn(name = "idgroupIncome", referencedColumnName = "idGroupIncome")
    @ManyToOne
    private GroupIncome idgroupIncome;
    @JoinColumn(name = "idMemberOfFamily", referencedColumnName = "idmemberOfFamily")
    @ManyToOne
    private MemberOfFamily idMemberOfFamily;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIncome", fetch = FetchType.EAGER)
    private Collection<PropertiesIncome> propertiesIncomeCollection;

    public Income() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupIncome() {
        return groupIncome;
    }

    public void setGroupIncome(String groupIncome) {
        this.groupIncome = groupIncome;
    }

    public String getNameIncome() {
        return nameIncome;
    }

    public void setNameIncome(String nameIncome) {
        this.nameIncome = nameIncome;
    }






    public MemberOfFamily getIdMemberOfFamily() {
        return idMemberOfFamily;
    }

    public void setIdMemberOfFamily(MemberOfFamily idMemberOfFamily) {
        this.idMemberOfFamily = idMemberOfFamily;
    }

    public GroupIncome getIdgroupIncome() {
        return idgroupIncome;
    }

    public void setIdgroupIncome(GroupIncome idgroupIncome) {
        this.idgroupIncome = idgroupIncome;
    }

    public Collection<PropertiesIncome> getPropertiesIncomeCollection() {
        return propertiesIncomeCollection;
    }

    public void setPropertiesIncomeCollection(Collection<PropertiesIncome> propertiesIncomeCollection) {
        this.propertiesIncomeCollection = propertiesIncomeCollection;
    }
}
