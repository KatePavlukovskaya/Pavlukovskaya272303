package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Cost;
import com.springapp.mvc.domain.Income;
import com.springapp.mvc.domain.PropertiesIncome;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class IncomeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addContact(Income income){
        this.sessionFactory.getCurrentSession().save(income);
    }

    public List<Income> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Income").list();
    }

    public List<Income> listAllMember(Integer id){
        return this.sessionFactory.getCurrentSession().createQuery("from Income income where idMemberOfFamily.id="+id).list();
    }

    public void removeIncome(Integer iD){
        Income contact = (Income)this.sessionFactory.getCurrentSession().load(Income.class, iD);
        if (null!=contact){
            if(contact.getPropertiesIncomeCollection().size()==1) {
                this.sessionFactory.getCurrentSession().delete(contact);
            }
        }
    }
    public Income findIncome(Integer iD) {
        Income income = (Income) this.sessionFactory.getCurrentSession().get(Income.class, iD);
        return income;
    }

    public void updateIncome(Income income){

        this.sessionFactory.getCurrentSession().saveOrUpdate(income);
    }


    public List<Income> statisticAll(){
        List<Income> a = null;
        a.equals(this.sessionFactory.getCurrentSession().createQuery("from Income").list());

        return null;
    }
}
