/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.pojos.RowCategoria;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Usuario
 */
@Named
@SessionScoped
public class CollectionBeanCategoria implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Set<RowCategoria> list = new HashSet<RowCategoria>();
    private int id;
    private String nombre;
    private boolean editable;
    
    public CollectionBeanCategoria() {
        
        this.list.add(new RowCategoria(5, "Construcción"));
        this.list.add(new RowCategoria(6, "Herraje"));
        
    }
    
    public String add() {
	this.list.add(new RowCategoria(id, nombre));
	return null;
    }

    public String delete(RowCategoria t) {
	this.list.remove(t);
	return null;
    }

    public String edit(RowCategoria t) {
	t.setEditable(true);
	return null;
    }

    public String save(RowCategoria t) {
	t.setEditable(false);
	return null;
    }

    public RowCategoria[] getList() {
	return list.toArray(new RowCategoria[0]);
    }

    public void setList(Set<RowCategoria> list) {
	this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    
    
    
}

    

