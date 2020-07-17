/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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

/**
 *
 * @author Galew
 */
@Entity
@Table(name = "listing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listing.findAll", query = "SELECT l FROM Listing l")
    , @NamedQuery(name = "Listing.findByPk", query = "SELECT l FROM Listing l WHERE l.pk = :pk")})
public class Listing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk")
    private Integer pk;
    @JoinColumn(name = "codex_pk", referencedColumnName = "pk")
    @ManyToOne(optional = false)
    private Codex codexPk;
    @JoinColumn(name = "symbol_pk", referencedColumnName = "pk")
    @ManyToOne(optional = false)
    private Symbol symbolPk;

    public Listing() {
    }

    public Listing(Integer pk) {
        this.pk = pk;
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public Codex getCodexPk() {
        return codexPk;
    }

    public void setCodexPk(Codex codexPk) {
        this.codexPk = codexPk;
    }

    public Symbol getSymbolPk() {
        return symbolPk;
    }

    public void setSymbolPk(Symbol symbolPk) {
        this.symbolPk = symbolPk;
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
        if (!(object instanceof Listing)) {
            return false;
        }
        Listing other = (Listing) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Listing[ pk=" + pk + " ]";
    }
    
}
