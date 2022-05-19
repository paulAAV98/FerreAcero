/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private int  detalle_cantidad;
    private double detalle_precio;
    private double detalle_iva;
    private double detalle_total;
    
    private Producto producto;

    public int getDetalle_id() {
        return detalle_id;
    }

    public void setDetalle_id(int detalle_id) {
        this.detalle_id = detalle_id;
    }

    public int getDetalle_cantidad() {
        return detalle_cantidad;
    }

    public void setDetalle_cantidad(int detalle_cantidad) {
        this.detalle_cantidad = detalle_cantidad;
    }

    public double getDetalle_precio() {
        return detalle_precio;
    }

    public void setDetalle_precio(double detalle_precio) {
        this.detalle_precio = detalle_precio;
    }

    public double getDetalle_iva() {
        return detalle_iva;
    }

    public void setDetalle_iva(double detalle_iva) {
        this.detalle_iva = detalle_iva;
    }

    public double getDetalle_total() {
        return detalle_total;
    }

    public void setDetalle_total(double detalle_total) {
        this.detalle_total = detalle_total;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
   
    
    
    
    
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (!(object instanceof CarritoDetalle)) {
            return false;
        }
        CarritoDetalle other = (CarritoDetalle) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.entidades.CarritoDetalle[ id=" + id + " ]";
    }
    
}
