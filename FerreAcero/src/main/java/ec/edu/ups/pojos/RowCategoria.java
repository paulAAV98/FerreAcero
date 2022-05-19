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
public class RowCategoria implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String nombre;
    private boolean editable;

    public RowCategoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        
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
    public boolean equals(Object obj) {
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return "RowCategoria{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
}
