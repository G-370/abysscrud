/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import model.Symbol;

/**
 *
 * @author Galew
 */
@Named(value = "symbol_table")
@SessionScoped
public class Symbol_Management implements Serializable {
    
    
    private List<Symbol> table;
    private String symbolname;
    private Symbol entity;
    @EJB
    private Symbol_DataCruncher datacruncher;
    
    

    public List<Symbol> getTable() {
        return table;
    }
    
    public Symbol getEntity() {
        return entity;
    }
    
    public String getSymbolname() {
        return symbolname;
    }

    public void setTable(List<Symbol> table) {
        this.table = table;
    }
    
    public void setEntity(Symbol entity) {
        this.entity = entity;
    }
    
    public void setSymbolname(String symbolname) {
        this.symbolname = symbolname;
    }
    
    
    /**
     * Creates a new instance of symbol_table
     */
    public Symbol_Management() {
        
    }
    
    @PostConstruct
    public void init() {
        this.table = new ArrayList<>();
        this.entity = new Symbol();
        fetchfromDB();
    }
    
    private void fetchfromDB(){
        this.table = ( List<Symbol> ) (datacruncher.fetchAll("Symbol"));
    }
    
    public void updatepage_btn() {
        fetchfromDB();
    }
    
    public String edit_btn() {
        return "createSymbol?faces-redirect=true";
    }
    
    public void del_btn() {
        datacruncher.remove(this.entity);
        updatepage_btn();
    }
    
    public String save_btn() {
        datacruncher.save(this.entity);
        updatepage_btn();
        return "index?faces-redirect=true";
    }
    
    public void searchbyname_btn() {
        this.table = datacruncher.fetchName("Symbol", this.symbolname);
    }
    
}
