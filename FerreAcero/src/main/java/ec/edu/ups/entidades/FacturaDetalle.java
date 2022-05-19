/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;


import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

/**
 *
 * @author Usuario R
 */
@Entity
public class FacturaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int cantidad;
    private double total;
    @ManyToOne
    @JoinColumn
    private FacturaCabecera factura;
    
    public FacturaDetalle(){
        super();
    }

    public FacturaDetalle(int id, int cantidad, double total, FacturaCabecera factura) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
        this.factura = factura;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public FacturaCabecera getFactura() {
        return factura;
    }

    public void setFactura(FacturaCabecera factura) {
        this.factura = factura;
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
        if (getClass()!= other.getClass()) {
            return false;
        }
        return other.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return "ec.edu.ups.entidades.FacturaDetalle[ id=" + id + " ]";
    }
    
}
