package com.springapp.mvc.domain;

import com.springapp.mvc.domain.MemberOfFamily;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "authority")
public class Authority implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "au_id")
    private Integer auId;
    @Column(name = "authority")
    private String authority;
    @JoinColumn(name = "u_id", referencedColumnName = "idmemberOfFamily")
    @ManyToOne
    private MemberOfFamily uId;



    public Integer getAuId() {
        return auId;
    }

    public void setAuId(Integer auId) {
        this.auId = auId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public MemberOfFamily getUId() {
        return uId;
    }

    public void setUId(MemberOfFamily uId) {
        this.uId = uId;
    }



}
