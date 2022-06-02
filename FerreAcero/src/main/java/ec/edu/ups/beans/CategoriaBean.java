/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Producto;
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
import java.util.Random;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Usuario
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CategoriaBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private CategoriaFacade categoriaFacade;
    private List<Categoria> list = new ArrayList<>();
    private int id;
    private String nombre;
    
    @PostConstruct
     public void init() {	
	list = categoriaFacade.findAll();
    }
    
    public String add() {	
        categoriaFacade.create(new Categoria(id, nombre));
        list = categoriaFacade.findAll();
	return null;
    }

    public String delete(Categoria c) {
	categoriaFacade.remove(c);
        list = categoriaFacade.findAll();
	return null;
    }
    
    public String edit(Categoria c){
        categoriaFacade.edit(c);
        list = categoriaFacade.findAll();
        return null;
    }

    

    public Categoria[] getList() {
	return list.toArray(new Categoria[0]);
    }

    public void setList(List<Categoria> list) {
	this.list = list;
    }

    public CategoriaFacade getCategoriaFacade() {
        return categoriaFacade;
    }

    public void setCategoriaFacade(CategoriaFacade categoriaFacade) {
        this.categoriaFacade = categoriaFacade;
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
    
    public void onRowEdit(RowEditEvent<Categoria> event) {
        FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getNombre()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }

    public void onRowCancel(RowEditEvent<Categoria> event) {
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
    

