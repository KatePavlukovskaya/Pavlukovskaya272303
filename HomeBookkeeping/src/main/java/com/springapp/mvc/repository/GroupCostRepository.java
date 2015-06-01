package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Cost;
import com.springapp.mvc.domain.GroupCost;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class GroupCostRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addContact(GroupCost group){
        this.sessionFactory.getCurrentSession().save(group);
    }

    public List<GroupCost> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from GroupCost").list();
    }

    public void removeGroupCost(Integer iD){
        GroupCost contact = (GroupCost)this.sessionFactory.getCurrentSession().load(GroupCost.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }
    public void updateGroupCost(GroupCost group){
        this.sessionFactory.getCurrentSession().saveOrUpdate(group);
    }

    public GroupCost findGroupCost(String nameGroup) {
        GroupCost groupCost = (GroupCost) this.sessionFactory.getCurrentSession().createQuery("from GroupCost as groupCost where nameGroup="+nameGroup);
        return groupCost;
    }

    public GroupCost findGroupCostId(Integer id) {
        GroupCost groupCost = (GroupCost) this.sessionFactory.getCurrentSession().get(GroupCost.class, id);
        return groupCost;
    }
}
