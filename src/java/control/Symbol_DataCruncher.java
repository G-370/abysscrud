/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Symbol;

/**
 *
 * @author Galew
 */
@Stateless
public class Symbol_DataCruncher {
    @PersistenceContext(name = "AbyssCRUDPU")
    EntityManager daemon;
    public void save(Symbol entity) {
        daemon.merge(entity);
    }
    public void remove(Symbol entity) {
        Query deletion = daemon.createNamedQuery("Symbol.trash");
        deletion.setParameter("pk", entity.getPk());
        deletion.executeUpdate();
    }
    
    public Symbol fetch(int pk) {
        return daemon.find( Symbol.class, pk);
    }
    public List<Symbol> fetchAll(String entity) {
        Query q = daemon.createNamedQuery(String.format("%s.findAll", entity));
        return q.getResultList();
    }
    
    public List<Symbol> fetchPk(String entity, int pk) {
        Query q = daemon.createNamedQuery(String.format("%s.findByPk", entity));
        q.setParameter("pk", pk);
        return q.getResultList();
    }
    
    public List<Symbol> fetchName(String entity, String name) {
        Query q = daemon.createNamedQuery(String.format("%s.findByName", entity));
        name = "%" + name + "%";
        q.setParameter("name", name);
        System.out.println(q.getResultList());
        return q.getResultList();
    }
    
    public List<Symbol> fetchVirtus(String entity, String virtus) {
        Query q = daemon.createNamedQuery(String.format("%s.findByVirtus", entity));
        q.setParameter(0, virtus);
        return q.getResultList();
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
