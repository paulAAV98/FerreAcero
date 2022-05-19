/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import ec.edu.ups.beans.FacturaCabecera;
import jakarta.persistence.CascadeType;
import java.io.Serializable;



/**
 *
 * @author Bernardo ct
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Persistence;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import java.util.GregorianCalendar;

@Entity
public class Persona implements Serializable{

   
    @Id
    private int per_id;
    private String  per_nombre;
    private String per_apellido;
    private String per_clave;
    private String per_cedula;
    private String per_direccion;
    private String per_email;
    private String per_telefono;
    @Transient
    private boolean editable;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Rols rol;
    @ManyToOne
    @JoinColumn
    private FacturaCabecera factura;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido, String clave, String cedula, String direccion, String email, String telefono, FacturaCabecera factura) {
        this.per_id = id;
        this.per_nombre = nombre;
        this.per_apellido = apellido;
        this.per_clave = clave;
        this.per_cedula = cedula;
        this.per_direccion = direccion;
        this.per_email = email;
        this.per_telefono = telefono;
        this.factura = factura;
        
        this.editable = editable;
        this.rol = rol;
    }

    public void setPer_apellido(String per_apellido) {
        this.per_apellido = per_apellido;
    }

    public void setPer_cedula(String per_cedula) {
        this.per_cedula = per_cedula;
    }

    public void setPer_clave(String per_clave) {
        this.per_clave = per_clave;
    }

    public void setPer_direccion(String per_direccion) {
        this.per_direccion = per_direccion;
    }

    public void setPer_email(String per_email) {
        this.per_email = per_email;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public void setPer_nombre(String per_nombre) {
        this.per_nombre = per_nombre;
    }

    public void setPer_rol(Rols per_rol) {
        this.rol = per_rol;
    }

    public void setPer_telefono(String per_telefono) {
        this.per_telefono = per_telefono;
    }

    public String getPer_apellido() {
        return per_apellido;
    }

    public String getPer_cedula() {
        return per_cedula;
    }

    public String getPer_clave() {
        return per_clave;
    }

    public String getPer_direccion() {
        return per_direccion;
    }

    public String getPer_email() {
        return per_email;
    }

    public int getPer_id() {
        return per_id;
    }

    public String getPer_nombre() {
        return per_nombre;
    }

    public Rols getPer_rol() {
        return rol;
    }

    public String getPer_telefono() {
        return per_telefono;
    }

    public FacturaCabecera getFactura() {
        return factura;
    }

    public void setFactura(FacturaCabecera factura) {
        this.factura = factura;
    }

  

   
    /*public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/
    
    
    
   
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    } 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) per_id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if (this.per_id != other.per_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + per_id + ", nombre=" + per_nombre + ", apellido=" + per_apellido + '}';
        }
     }