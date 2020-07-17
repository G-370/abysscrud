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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Galew
 */
@Entity
@Table(name = "symbol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Symbol.findAll", query = "SELECT s FROM Symbol s")
    , @NamedQuery(name = "Symbol.findByPk", query = "SELECT s FROM Symbol s WHERE s.pk = :pk")
    , @NamedQuery(name = "Symbol.findByName", query = "SELECT s FROM Symbol s WHERE s.name LIKE :name")
    , @NamedQuery(name = "Symbol.findByVirtus", query = "SELECT s FROM Symbol s WHERE s.virtus = :virtus")
    , @NamedQuery(name = "Symbol.findByTag", query = "SELECT s FROM Symbol s WHERE s.tag = :tag")
    , @NamedQuery(name = "Symbol.trash", query = "DELETE FROM Symbol s WHERE s.pk = :pk")})
public class Symbol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk")
    private Integer pk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "virtus")
    private String virtus;
    @Size(max = 3)
    @Column(name = "tag")
    private String tag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "symbolPk")
    private Collection<Listing> listingCollection;

    public Symbol() {
    }

    public Symbol(Integer pk) {
        this.pk = pk;
    }

    public Symbol(Integer pk, String name, String virtus) {
        this.pk = pk;
        this.name = name;
        this.virtus = virtus;
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

    public String getVirtus() {
        return virtus;
    }

    public void setVirtus(String virtus) {
        this.virtus = virtus;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
        if (!(object instanceof Symbol)) {
            return false;
        }
        Symbol other = (Symbol) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Symbol[ pk=" + pk + " ]";
    }
    
}
