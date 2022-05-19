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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Bernardo
 */
@Entity
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String latitud;
    private String longitud;
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "Sucursal")
    private Set<Producto> productos = new HashSet<Producto>();

    public Sucursal() {
    }

    public Sucursal(int id, String nombre, String latitud, String longitud) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public void addProductos(Producto producto){
        this.productos.add(producto);
    }
    
    public void removeProduct(Producto producto){
        this.productos.remove(producto);
    }
}