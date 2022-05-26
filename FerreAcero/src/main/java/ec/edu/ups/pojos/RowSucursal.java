/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.pojos;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class RowSucursal implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int id; 
    private String nombre;
    private String latitud;
    private String longitud;
    private boolean editable;

    public RowSucursal(int id, String nombre, String latitud, String longitud) {
        this.id = id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
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
    
    @Override
    public boolean equals(Object obj) {
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return "RowSucursal{" + "id=" + id + ", nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud + '}';
    }
    
    
    
}
