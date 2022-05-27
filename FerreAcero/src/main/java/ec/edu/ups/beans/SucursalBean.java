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
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private List<Sucursal> list=new ArrayList<>();
    private int id;
    private String nombre;
    private String latitud;
    private String longitud;
    
    @PostConstruct
    public void init(){
        list = sucursalFacade.findAll();
    }
    
    public String add(){
        sucursalFacade.create(new Sucursal(id, nombre, latitud, longitud));
        list = sucursalFacade.findAll();
        return null;
       
    }
        public String delete(Sucursal s){
         sucursalFacade.remove(s);
         list = sucursalFacade.findAll();
         return null;
        }
        
        public String edit(Sucursal s){
            s.setEditable(true);
            return null;
    }
        
        public String save(Sucursal s){
            sucursalFacade.edit(s);
            list = sucursalFacade.findAll();
            s.setEditable(false);
            return null;
        }

    public Sucursal[] getList(){
        return list.toArray(new Sucursal[0]);
    }
    
    public void setList(List<Sucursal> list){
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
    
    
}
