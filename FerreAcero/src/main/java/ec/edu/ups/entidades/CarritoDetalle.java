/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import java.io.Serializable;


/**
 *
 * @author ssnajs
 */
@Entity
public class CarritoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int detalle_id;
    private int detalle_cantidad;
    private double detalle_precio;
    private double detalle_iva;
    private double detalle_total;

    @ManyToOne
    @JoinColumn
    private Producto produto;
    
    @ManyToOne
    @JoinColumn
    private CarritoCabecera carritocabecera;

    @Transient
    private boolean editable;

    public CarritoDetalle() {
    }

    public CarritoDetalle(int detalle_id, int detalle_cantidad, double detalle_precio, double detalle_iva, double detalle_total, Producto produto, CarritoCabecera carritocabecera) {
        this.detalle_id = detalle_id;
        this.detalle_cantidad = detalle_cantidad;
        this.detalle_precio = detalle_precio;
        this.detalle_iva = detalle_iva;
        this.detalle_total = detalle_total;
        this.produto = produto;
        this.carritocabecera = carritocabecera;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    

    @Override
    public int hashCode() {
        return detalle_id;
    }

    @Override
    public boolean equals(Object other) {
// TODO: Warning - this method won't work in the case the id fields are not set
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        return other.hashCode() == this.hashCode();
    }

}
