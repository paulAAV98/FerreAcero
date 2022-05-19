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
    
    private int per_id;
    private String  per_nombre;
    private String per_apellido;
    private String per_clave;
    private String per_cedula;
    private String per_direccion;
    private String per_email;
    private String per_telefono;
    private boolean editable;

    public Row(int per_id, String per_nombre, String per_apellido, String per_clave, String per_cedula, String per_direccion, String per_email, String per_telefono) {
        this.per_id = per_id;
        this.per_nombre = per_nombre;
        this.per_apellido = per_apellido;
        this.per_clave = per_clave;
        this.per_cedula = per_cedula;
        this.per_direccion = per_direccion;
        this.per_email = per_email;
        this.per_telefono = per_telefono;
        
    }

    public int getPer_id() {
        return per_id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public String getPer_nombre() {
        return per_nombre;
    }

    public void setPer_nombre(String per_nombre) {
        this.per_nombre = per_nombre;
    }

    public String getPer_apellido() {
        return per_apellido;
    }

    public void setPer_apellido(String per_apellido) {
        this.per_apellido = per_apellido;
    }

    public String getPer_clave() {
        return per_clave;
    }

    public void setPer_clave(String per_clave) {
        this.per_clave = per_clave;
    }

    public String getPer_cedula() {
        return per_cedula;
    }

    public void setPer_cedula(String per_cedula) {
        this.per_cedula = per_cedula;
    }

    public String getPer_direccion() {
        return per_direccion;
    }

    public void setPer_direccion(String per_direccion) {
        this.per_direccion = per_direccion;
    }

    public String getPer_email() {
        return per_email;
    }

    public void setPer_email(String per_email) {
        this.per_email = per_email;
    }

    public String getPer_telefono() {
        return per_telefono;
    }

    public void setPer_telefono(String per_telefono) {
        this.per_telefono = per_telefono;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

   

   

    @Override
    public int hashCode() {
	return per_id;
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
	return "Row [id=" + per_id + ", nombre=" + per_nombre + ", editable=" + editable + "]";
    }
}
