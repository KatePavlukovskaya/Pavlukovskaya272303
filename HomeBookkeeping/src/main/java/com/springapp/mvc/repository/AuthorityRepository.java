package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Authority;
import com.springapp.mvc.domain.Cost;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AuthorityRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addContact(Authority authority){
        this.sessionFactory.getCurrentSession().save(authority);
    }

    public List<Authority> listAllMember(Integer id){
        return this.sessionFactory.getCurrentSession().createQuery("from Authority authority where uId.id="+id).list();
    }

    public void updateAuthority(Authority authority){
        this.sessionFactory.getCurrentSession().saveOrUpdate(authority);
    }
}
