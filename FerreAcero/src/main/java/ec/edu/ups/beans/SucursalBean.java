/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.ejb.SucursalFacade;
import ec.edu.ups.entidades.Sucursal;
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
 * @author Usuario
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class SucursalBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private SucursalFacade sucursalFacade;
    private List<Sucursal> list = new ArrayList<>();
    private int id;
    private String nombre;
    private String latitud;
    private String longitud;

    @PostConstruct
    public void init() {
        list = sucursalFacade.findAll();
    }

    public String add() {
        sucursalFacade.create(new Sucursal(id, nombre, latitud, longitud));
        list = sucursalFacade.findAll();
        return null;

    }

    public String delete(Sucursal s) {
        sucursalFacade.remove(s);
        list = sucursalFacade.findAll();
        return null;
    }

    public String edit(Sucursal s) {
        sucursalFacade.edit(s);
        list = sucursalFacade.findAll();
        return null;
    }


    public Sucursal[] getList() {
        return list.toArray(new Sucursal[0]);
    }

    public void setList(List<Sucursal> list) {
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

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public SucursalFacade getSucursalFacade() {
        return sucursalFacade;
    }

    public void setSucursalFacade(SucursalFacade sucursalFacade) {
        this.sucursalFacade = sucursalFacade;
    }

     public void onRowEdit(RowEditEvent<Sucursal> event) {
        FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getNombre()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }

    public void onRowCancel(RowEditEvent<Sucursal> event) {
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
