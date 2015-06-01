package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Cost;
import com.springapp.mvc.domain.MemberOfFamily;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CostRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addContact(Cost cost){
        this.sessionFactory.getCurrentSession().save(cost);
    }

    public List<Cost> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Cost").list();
    }

    public List<Cost> listAllMember(Integer id){
        return this.sessionFactory.getCurrentSession().createQuery("from Cost cost where idMember.id="+id).list();
    }

    public void removeCost(Integer iD){
        Cost contact = (Cost)this.sessionFactory.getCurrentSession().load(Cost.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }
    public Cost findCost(Integer iD) {
        Cost cost = (Cost) this.sessionFactory.getCurrentSession().get(Cost.class, iD);
        return cost;
    }

    public void updateCost(Cost cost){
        this.sessionFactory.getCurrentSession().saveOrUpdate(cost);
    }

    public List getGroupCost(Integer IdGroup){
          return  this.sessionFactory.getCurrentSession().createQuery("from Cost as cost where cost.idCost in( select groupCost.idgroupCost.idCost from GroupCost as groupCost where groupCost.idGroupCost='"+IdGroup+")')").list();

    }

}
