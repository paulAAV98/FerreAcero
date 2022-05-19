/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.pojos.RowCarritoCabecera;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author USUARIO
 */
@Named
@SessionScoped
public class CarritoCabeceraBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Set<RowCarritoCabecera> list = new HashSet<RowCarritoCabecera>();
    private int id;
    @Temporal(TemporalType.DATE)
    private GregorianCalendar fecha;
 

    public CarritoCabeceraBean() {
	this.list.add(new RowCarritoCabecera(1, new GregorianCalendar (2021,01,14)));
        this.list.add(new RowCarritoCabecera(2, new GregorianCalendar (2020,04,11)));
        this.list.add(new RowCarritoCabecera(3, new GregorianCalendar (2022,05,17)));
        this.list.add(new RowCarritoCabecera(4, new GregorianCalendar (2021,07,20)));
    }

    public String add() {
	this.list.add(new RowCarritoCabecera(id, fecha));
	return null;
    }

    public String delete(RowCarritoCabecera t) {
	this.list.remove(t);
	return null;
    }

    public String edit(RowCarritoCabecera t) {
	t.setEditable(true);
	return null;
    }

    public String save(RowCarritoCabecera t) {
	t.setEditable(false);
	return null;
    }
    
    
    
    
    
}
