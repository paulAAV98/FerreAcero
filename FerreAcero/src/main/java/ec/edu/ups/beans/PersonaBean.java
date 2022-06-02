/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Persona;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author bernardo
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PersonaBean implements Serializable {
     private static final long serialVersionUID = 1L;
     
     @EJB
     private PersonaFacade personaFacade;     
     private List<Persona> list = new ArrayList<>();
     private int per_id;
    private String per_nombre;
    private String per_apellido;
    private String per_clave;
    private String per_cedula;
    private String per_direccion;
    private String per_email;
    private String per_telefono;

    @PostConstruct
    public void init() {	
	list = personaFacade.findAll();
    }
    
    public String add() {	
        personaFacade.create(new Persona(per_id,per_nombre, per_apellido));
        list = personaFacade.findAll();
	return null;
    }

    public String delete(Persona p) {
	personaFacade.remove(p);
        list = personaFacade.findAll();
	return null;
    }

    public String edit(Persona p) {
	p.setEditable(true);
	return null;
    }

    public String save(Persona p) {
        personaFacade.edit(p);
        list = personaFacade.findAll();
	p.setEditable(false);
	return null;
    }

    public Persona[] getList() {
	return list.toArray(new Persona[0]);
    }

    public void setList(List<Persona> list) {
	this.list = list;
    }

    public PersonaFacade getUserFacade() {
        return personaFacade;
    }

    public void setUserFacade(PersonaFacade personaFacade) {
        this.personaFacade = personaFacade;
    }

    public int getPer_id() {
        return per_id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public String getPer_nombre() {
        return per_nombre;
    }

    public void setPer_nombre(String per_nombre) {
        this.per_nombre = per_nombre;
    }

    public String getPer_apellido() {
        return per_apellido;
    }

    public void setPer_apellido(String per_apellido) {
        this.per_apellido = per_apellido;
    }

    public String getPer_clave() {
        return per_clave;
    }

    public void setPer_clave(String per_clave) {
        this.per_clave = per_clave;
    }

    public String getPer_cedula() {
        return per_cedula;
    }

    public void setPer_cedula(String per_cedula) {
        this.per_cedula = per_cedula;
    }

    public String getPer_direccion() {
        return per_direccion;
    }

    public void setPer_direccion(String per_direccion) {
        this.per_direccion = per_direccion;
    }

    public String getPer_email() {
        return per_email;
    }

    public void setPer_email(String per_email) {
        this.per_email = per_email;
    }

    public String getPer_telefono() {
        return per_telefono;
    }

    public void setPer_telefono(String per_telefono) {
        this.per_telefono = per_telefono;
    }

    
   

    public void setPersonaFacade(PersonaFacade personaFacade) {
        this.personaFacade = personaFacade;
    }    
     public void onRowEdit(RowEditEvent<Persona> event) {
        FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getPer_nombre()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }

    public void onRowCancel(RowEditEvent<Persona> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getPer_nombre()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
