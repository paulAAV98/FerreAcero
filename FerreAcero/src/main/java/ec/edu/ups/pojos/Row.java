/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.pojos;

import java.io.Serializable;

/**
 *
 * @author Gabus
 */
public class Row implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int id;
    private String  nombre;
    private String apellido;
    private String clave;
    private String cedula;
    private String direccion;
    private String email;
    private String telefono;
    private boolean editable;

    public Row(int id, String nombre, String apellido, String clave, String cedula, String direccion, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.cedula = cedula;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
	return "Row [id=" + id + ", nombre=" + nombre + ", editable=" + editable + "]";
    }
}
