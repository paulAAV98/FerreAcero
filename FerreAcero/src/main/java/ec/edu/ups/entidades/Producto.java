/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;


/**
 *
 * @author Bernardo
 */
@Entity
public class Producto implements Serializable {
    
    //------------------------------------------------ManyToOne
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String marca;
    private double precio;
    private int stock;
    @ManyToOne
    @JoinColumn
    private Categoria categoria;
    @ManyToOne
    @JoinColumn
    private Sucursal sucursal;
    private boolean editable;

       public Producto() {
        super();
    }
    
    public Producto(int id, String nombre, String marca, double precio, int stock, Categoria categoria, Sucursal sucursal) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.sucursal = sucursal;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
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

