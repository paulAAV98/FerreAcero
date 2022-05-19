/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.pojos;

import ec.edu.ups.entidades.CarritoCabecera;
import ec.edu.ups.entidades.Producto;
import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
public class RowCarritoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int detalle_id;
    private int  detalle_cantidad;
    private double detalle_precio;
    private double detalle_iva;
    private double detalle_total;
    
    private CarritoCabecera carritocabecera;
    private Producto producto;
    private boolean editable;
    

    public RowCarritoDetalle(int detalle_id, int detalle_cantidad, double detalle_precio, double detalle_iva, double detalle_total, CarritoCabecera carritocabecera, Producto producto) {
        this.detalle_id = detalle_id;
        this.detalle_cantidad = detalle_cantidad;
        this.detalle_precio = detalle_precio;
        this.detalle_iva = detalle_iva;
        this.detalle_total = detalle_total;
        this.carritocabecera = carritocabecera;
        this.producto = producto;
    }

    public CarritoCabecera getCarritocabecera() {
        return carritocabecera;
    }

    public void setCarritocabecera(CarritoCabecera carritocabecera) {
        this.carritocabecera = carritocabecera;
    }


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

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    

    
    
}
