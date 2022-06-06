/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.FacturaFacade;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Factura;
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
public class FacturaBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private FacturaFacade facturaFacade;
    private List<Factura> list = new ArrayList<>();
    private int id;
    private String nombre;
    private int numero;
    private Date fecha;
    private Persona persona;
    private double total,subtotal;
    private String nombreCliente;
    private String cedula;
    
    @PostConstruct
     public void init() {	
	list = facturaFacade.findAll();
    }
    
    public String add() {	
        //facturaFacade.create(new Factura(id, numero, fecha, total, subtotal));
        list = facturaFacade.findAll();
	return null;
    }

    public String delete(Factura c) {
	facturaFacade.remove(c);
        list = facturaFacade.findAll();
	return null;
    }

    

    public Factura[] getList() {
	return list.toArray(new Factura[0]);
    }

    public void setList(List<Factura> list) {
	this.list = list;
    }

    public FacturaFacade getfacturaFacade() {
        return facturaFacade;
    }

    public void setCategoriaFacade(FacturaFacade facturaFacadeFacade) {
        this.facturaFacade= facturaFacadeFacade;
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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public FacturaFacade getFacturaFacade() {
        return facturaFacade;
    }

    public int getNumero() {
        return numero;
    }

    public Persona getPersona() {
        return persona;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }
        public void buscarCliente(){
        persona = facturaFacade.getpersonaN(getCedula());
        
    }

    public void setIdCliente(String cedula) {
        this.cedula = cedula;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

   

    public String getNombreCliente() {
        return nombreCliente;
    }
    
    
}
