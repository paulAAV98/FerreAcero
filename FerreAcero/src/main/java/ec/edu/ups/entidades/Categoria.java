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
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Bernardo
 */
@Entity
public class Categoria implements Serializable {

    //-----------------------------------------------OneToMany
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Categoria")
    private Set<Producto> productos = new HashSet<Producto>();
    
    public Categoria() {
        super();
    }
    
    public Categoria(int id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    
    
    public void addProductos(Producto producto){
        this.productos.add(producto);
    }
    
    public void removeProduct(Producto producto){
        this.productos.remove(producto);
    }

}
