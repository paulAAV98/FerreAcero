/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

/**
 *
 * @author Bernardo
 */
public class fac_detalle {
    
    public double cantidad;
    public double precio;
    public String nombrex;
    public double subtotal;
    public int id_producto;
    FacturaBean facbean;
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_producto() {
        return id_producto;
    }
    
    
    
   

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setNombrex(String nombrex) {
        this.nombrex = nombrex;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getNombrex() {
        return nombrex;
    }

    public double getPrecio() {
        return precio;
    }

    public double getSubtotal() {
        return subtotal;
    }
    
    public void buscarP(){
        
        
    }
    @Override
    public String toString() {
        return "fac_detalle{" + "nombre=" + nombrex +  '}';
    }
    
}
