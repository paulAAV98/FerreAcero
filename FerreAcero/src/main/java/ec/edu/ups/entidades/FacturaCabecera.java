/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author Usuario R
 */
@Entity
public class FacturaCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double subtotal;
    private int iva;
    private double total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private Set<FacturaDetalle> facturadetalles = new HashSet<FacturaDetalle>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private Set<Persona> personas = new HashSet<Persona>();
    
    public FacturaCabecera(){
        super();
    }

    public FacturaCabecera(int id, double subtotal, int iva, double total) {
        super();
        this.id = id;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    public Set<FacturaDetalle> getFacturadetalles() {
        return facturadetalles;
    }

    public void setFacturadetalles(Set<FacturaDetalle> facturadetalles) {
        this.facturadetalles = facturadetalles;
    }
    
    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }
    public void addFacturaDetalle(FacturaDetalle detalle){
        this.facturadetalles.add(detalle);
    }
    public void removeFacturaDetalle(FacturaDetalle detalle){
        this.facturadetalles.remove(detalle);
    }
    public void addPersona(Persona persona){
        this.personas.add(persona);
    }
    public void removePersona(Persona persona){
        this.personas.remove(persona);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCabecera)) {
            return false;
        }
        FacturaCabecera other = (FacturaCabecera) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.entidades.FacturaCabecera[ id=" + id + " ]";
    }
    
}
