package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Cost;
import com.springapp.mvc.domain.PropertiesCost;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;


@Repository
@Transactional
public class PropertiesCostRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addContact(PropertiesCost properties){
        this.sessionFactory.getCurrentSession().save(properties);
    }

    public List<PropertiesCost> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from PropertiesCost").list();
    }

    public void removePropertiesCost(Integer iD){
        PropertiesCost cont = (PropertiesCost) this.sessionFactory.getCurrentSession().get(PropertiesCost.class, iD);
        if (null!=cont){
            this.sessionFactory.getCurrentSession().delete(cont);
        }
    }

    public List getPropertiesData(Integer month, Integer nyear) {
        List<PropertiesCost> propertiesList = null;
        int  year, day=1;
        year=nyear-1900;
        Date start = new Date(year, month, day);
        month=month+1;
        day=1;
        Date end = new Date(year, month, day);

            return this.sessionFactory.getCurrentSession().createQuery("from PropertiesCost prop where(prop.data between '"+start+"' and '"+end+"')").list();


    }

    public void updatePropertiesCost(PropertiesCost cost){
        this.sessionFactory.getCurrentSession().saveOrUpdate(cost);
    }

    public PropertiesCost findPropertiesCost(Integer iD) {
        PropertiesCost propertiesCost = (PropertiesCost) this.sessionFactory.getCurrentSession().get(PropertiesCost.class, iD);
        return propertiesCost;
    }
}
