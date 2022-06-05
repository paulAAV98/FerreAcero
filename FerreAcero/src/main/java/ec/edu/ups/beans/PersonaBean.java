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
     private int id;
    private String nombre;
    private String apellido;
    private String clave;
    private String cedula;
    private String direccion;
    private String email;
    private String telefono;

    @PostConstruct
    public void init() {	
	list = personaFacade.findAll();
    }
    
    public String add() {	
        personaFacade.create(new Persona(id, nombre, apellido, clave, cedula, direccion, email, telefono));
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
   

    public void setPersonaFacade(PersonaFacade personaFacade) {
        this.personaFacade = personaFacade;
    }    
     public void onRowEdit(RowEditEvent<Persona> event) {
        FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getNombre()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }

    public void onRowCancel(RowEditEvent<Persona> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getNombre()));
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
