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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

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
    @ManyToOne
    @JoinColumn
    private Persona persona; 


    
    
    
    public FacturaCabecera(){
        super();
    }

    public FacturaCabecera(int id, double subtotal, int iva, double total, Persona per) {
        super();
        this.id = id;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.persona = persona;
    }

    
     public void addFacturaDetalle(FacturaDetalle facturadetalle){
        this.facturadetalles.add(facturadetalle);
    }
    
    public void removeProduct(FacturaDetalle facturadetalle){
        this.facturadetalles.remove(facturadetalle);
    }
    
     @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (other == null) {
            return false;
        }
        if(getClass() != other.getClass()){
           return false; 
        }
        return other.hashCode() == this.hashCode();
    }
}
