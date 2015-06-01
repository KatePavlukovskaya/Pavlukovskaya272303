package com.springapp.mvc.repository;

import com.springapp.mvc.domain.MemberOfFamily;
import com.springapp.mvc.validation.MemberValidation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import javax.xml.ws.BindingProvider;
import java.util.List;

@Repository
@Transactional
public class MemberOfFamilyRepository {
    @Autowired
    private SessionFactory sessionFactory;


    public void addMember(MemberOfFamily member){
        this.sessionFactory.getCurrentSession().save(member);
    }

    public List<MemberOfFamily> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from MemberOfFamily").list();
    }

    public void removeMember(Integer iD){
        MemberOfFamily member = (MemberOfFamily)this.sessionFactory.getCurrentSession().load(MemberOfFamily.class, iD);
        if ((null)!=member){
            this.sessionFactory.getCurrentSession().delete(member);
        }
    }

    public MemberOfFamily findMember(Integer iD) {
        MemberOfFamily member = (MemberOfFamily) this.sessionFactory.getCurrentSession().get(MemberOfFamily.class, iD);
        return member;
    }

    public MemberOfFamily findMemberLogin(String login) {
        List<MemberOfFamily> memberOfFamily = (List<MemberOfFamily>) this.sessionFactory.getCurrentSession().createQuery("from MemberOfFamily as memberOfFamily where login like"+login).list();
        System.out.println(memberOfFamily);
        return memberOfFamily.iterator().next();
    }

    public void updateMember(MemberOfFamily member){
        this.sessionFactory.getCurrentSession().saveOrUpdate(member);
    }

}
