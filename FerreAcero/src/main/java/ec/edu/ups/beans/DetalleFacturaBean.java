/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.Detalle_FacturaFacade;
import ec.edu.ups.ejb.FacturaFacade;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Factura;
import ec.edu.ups.entidades.Factura_Detalle;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Producto;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class DetalleFacturaBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private FacturaFacade facturaFacade;
    @EJB
    private Detalle_FacturaFacade fac_fa_det;
    private int id;
        private double valor_unitario;
        private int cantidad;
        private List<Factura_Detalle> list = new ArrayList<>();
        private Producto pro;
        private Factura fac;
        
    @PostConstruct
     public void init() {	
	list = fac_fa_det.findAll();
    }
    
    public String add() {	
        fac_fa_det.create(new Factura_Detalle(id, valor_unitario, cantidad, pro, fac));
        
        list = fac_fa_det.findAll();
	return null;
    }

    public String delete(Factura_Detalle c) {
	fac_fa_det.remove(c);
        list = fac_fa_det.findAll();
	return null;
    }

    

    public Factura_Detalle[] getList() {
	return list.toArray(new Factura_Detalle[0]);
    }

    public void setList(List<Factura_Detalle> list) {
	this.list = list;
    }

    public FacturaFacade getfacturaFacade() {
        return facturaFacade;
    }

    public void setCategoriaFacade(FacturaFacade facturaFacadeFacade) {
        this.facturaFacade= facturaFacadeFacade;
    }

   
    public FacturaFacade getFacturaFacade() {
        return facturaFacade;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFacturaFacade(FacturaFacade facturaFacade) {
        this.facturaFacade = facturaFacade;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setFac(Factura fac) {
        this.fac = fac;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public Factura getFac() {
        return fac;
    }

    public int getId() {
        return id;
    }

    public Producto getPro() {
        return pro;
    }

    

    
}
