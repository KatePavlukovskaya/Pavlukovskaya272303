package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Cost;
import com.springapp.mvc.domain.Goal;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GoalRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addContact(Goal goal){
        this.sessionFactory.getCurrentSession().save(goal);
    }

    public List<Goal> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Goal").list();
    }

    public List<Goal> listAllMember(Integer id){
        return this.sessionFactory.getCurrentSession().createQuery("from Goal goal where idMemberOfFamily.id="+id).list();
    }

    public void removeBook(Integer iD){
        Goal contact = (Goal)this.sessionFactory.getCurrentSession().load(Goal.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }
}

