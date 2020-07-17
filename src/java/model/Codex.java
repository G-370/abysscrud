/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Galew
 */
@Entity
@Table(name = "codex")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Codex.findAll", query = "SELECT c FROM Codex c")
    , @NamedQuery(name = "Codex.findByPk", query = "SELECT c FROM Codex c WHERE c.pk = :pk")
    , @NamedQuery(name = "Codex.findByName", query = "SELECT c FROM Codex c WHERE c.name = :name")
    , @NamedQuery(name = "Codex.findByBranch", query = "SELECT c FROM Codex c WHERE c.branch = :branch")})
public class Codex implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk")
    private Integer pk;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "branch")
    private String branch;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codexPk")
    private Collection<Listing> listingCollection;

    public Codex() {
    }

    public Codex(Integer pk) {
        this.pk = pk;
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @XmlTransient
    public Collection<Listing> getListingCollection() {
        return listingCollection;
    }

    public void setListingCollection(Collection<Listing> listingCollection) {
        this.listingCollection = listingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codex)) {
            return false;
        }
        Codex other = (Codex) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Codex[ pk=" + pk + " ]";
    }
    
}
