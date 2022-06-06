/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.view;

import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Sucursal;
import ec.edu.ups.service.CategoriaService;
import ec.edu.ups.service.SucursalService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Usuario
 */
@Named("scEditView")
@ViewScoped
public class EditViewSucursal implements Serializable {
    
    private List<Sucursal>sucursales;
    
    @Inject
    private SucursalService Sucursalservice;
    
    @PostConstruct
    public void init(){
            sucursales = Sucursalservice.getClonedSucursales(10);
    }
    
    public List<Sucursal> getSucursales(){
        return sucursales;
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