package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Cost;
import com.springapp.mvc.domain.PropertiesCost;
import com.springapp.mvc.domain.PropertiesIncome;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public class PropertiesIncomeRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public void addContact(PropertiesIncome properties){
        this.sessionFactory.getCurrentSession().save(properties);
    }

    public List<PropertiesIncome> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from PropertiesIncome").list();
    }

    public void removePropertiesIncome(Integer iD){
        PropertiesIncome contact = (PropertiesIncome)this.sessionFactory.getCurrentSession().get(PropertiesIncome.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }

    public List getPropertiesData(Integer month, Integer nyear) {
        List<PropertiesIncome> propertiesList = null;
        int  year, day=1;
        year=nyear-1900;
        Date start = new Date(year, month, day);
        month=month+1;
        day=1;
        Date end = new Date(year, month, day);

        return this.sessionFactory.getCurrentSession().createQuery("from PropertiesIncome prop where(prop.data between '"+start+"' and '"+end+"')").list();

    }

    public void updatePropertiesIncome(PropertiesIncome income){
        this.sessionFactory.getCurrentSession().saveOrUpdate(income);
    }

    public PropertiesIncome findPropertiesIncome(Integer iD) {
        PropertiesIncome propertiesIncome = (PropertiesIncome) this.sessionFactory.getCurrentSession().get(PropertiesIncome.class, iD);
        return propertiesIncome;
    }
}
