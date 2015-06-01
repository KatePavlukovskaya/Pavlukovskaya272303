package com.springapp.mvc.repository;

import com.springapp.mvc.domain.GroupCost;
import com.springapp.mvc.domain.GroupIncome;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GroupIncomeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addContact(GroupIncome group){
        this.sessionFactory.getCurrentSession().save(group);
    }

    public List<GroupIncome> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from GroupIncome").list();
    }

    public void removeBook(Integer iD){
        GroupIncome contact = (GroupIncome)this.sessionFactory.getCurrentSession().load(GroupIncome.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }
    public GroupIncome findGroupIncomeId(Integer id) {
        GroupIncome groupIncome = (GroupIncome) this.sessionFactory.getCurrentSession().get(GroupIncome.class, id);
        return groupIncome;
    }
}
