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

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

/**
 *
 * @author Bernardo
 */
@Entity
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private String nombre;
    private String latitud;
    private String longitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal")
    private Set<Producto> productos = new HashSet<Producto>();
    @Transient
    private boolean editable;

    public Sucursal() {
        super();
    }

    public Sucursal(int id, String nombre, String latitud, String longitud) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    @Override
    public Sucursal clone() {
        return new Sucursal(getId(), getNombre(), getLatitud(), getLongitud());
    }
    

    public void addProductos(Producto producto) {
        this.productos.add(producto);
    }

    public void removeProduct(Producto producto) {
        this.productos.remove(producto);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

<<<<<<< HEAD

   /* @Override
    public String toString() {
        return "Sucursal{" + "id=" + id + ", nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud + '}';
    }*/
    
    @Override
    public String toString() {
        return "Sucursal{" + "id=" + id + ", nombre=" + nombre +'}';
    }
=======
    @Override
    public String toString() {
        return "Sucursal{" + "id=" + id + ", nombre=" + nombre + '}';
    }

>>>>>>> d186f221cb8b32c5206f62d6804d707b6845ef93

}
