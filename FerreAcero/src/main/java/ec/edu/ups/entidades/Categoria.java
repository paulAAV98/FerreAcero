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
import jakarta.persistence.Transient;
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
     private int id;
    @GeneratedValue(strategy = GenerationType.AUTO)
   
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private Set<Producto> productos = new HashSet<Producto>();
    @Transient
    
    private boolean editable;
    
    
    public Categoria() {
        super();
    }
    
    public Categoria(int id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    
    
    public void addProductos(Producto producto){
        this.productos.add(producto);
    }
    
    public void removeProduct(Producto producto){
        this.productos.remove(producto);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    

}
