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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Bernardo
 */
@Entity
public class Factura implements Serializable {

    
    
    
    
    
    
    
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numero;
    private Date fecha;
    @ManyToOne
    @JoinColumn
    private Persona persona;
    private double total,subtotal;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    
    private Set<Factura_Detalle> detalle = new HashSet<Factura_Detalle>();

    public Factura() {
    }

   
    public Factura(int id, int numero, Date fecha, double total, double subtotal,Persona persona) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        
        this.total = total;
        this.subtotal = subtotal;
        
        this.persona=persona;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.entidades.NewEntity[ id=" + id + " ]";
    }

    public void setDetalle(Set<Factura_Detalle> detalle) {
        this.detalle = detalle;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<Factura_Detalle> getDetalle() {
        return detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getNumero() {
        return numero;
    }

    public Persona getPersona() {
        return persona;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }
    
}
